<?php
App::uses('AppModel', 'Model');
class Post extends AppModel{

	public $actsAs = array('Upload.Upload' => array(
		'fields' => array(
			'thumb' => 'img/tmp/test1-:id',
			'thumb2' => 'img/tmp/test2-:id'
		)
	));
	public $validate = array(
		'thumb_file' => array(
			'rule' => array('fileExtension', array('jpg','png'))
		)
	);
}

// Replace move_uploaded_file for testing purposes
function test_move_uploaded_file($filename, $destination){
    return copy($filename, $destination);
}

class UploadBehaviorTest extends CakeTestCase {

	public $fixtures = array(
		'plugin.upload.post'
	);

	public function setUp() {
		parent::setUp();
		if(!file_exists(IMAGES . 'tmp')){
			mkdir(IMAGES . 'tmp');
		}
		$this->image = ROOT . DS . APP_DIR . DS . 'Plugin' . DS . 'Upload' . DS . 'Test' . DS . 'zoidberg.jpg';
		$this->imagepng = ROOT . DS . APP_DIR . DS . 'Plugin' . DS . 'Upload' . DS . 'Test' . DS . 'zoidberg.png';
        $this->Post = $this->getMockForModel('Upload.Post', array('move_uploaded_file'));
		$this->Post->expects($this->any())->method('move_uploaded_file')->will($this->returnCallback('test_move_uploaded_file'));
	}

	public function tearDown() {
		unset($this->Post);
		rmdir(IMAGES . 'tmp');
		parent::tearDown();
	}

	public function testValidationExtension(){
		$file = array('name' => 'zoidberg.pdf','type' => 'image/jpg','tmp_name' => 'test/test.pdf','error' => (int) 0,'size' => (int) 52085);
		$save = $this->Post->save(array(
			'id' => 1,
			'thumb_file' => $file
		));
		$this->assertEquals(false, $save);
	}

    public function testFileUpload() {
        $file = array('name' => 'zoidberg.jpg','type' => 'image/jpg','tmp_name' => $this->image,'error' => (int) 0,'size' => (int) 52085);
        $file_empty = array('name' => '','type' => '','tmp_name' => '','error' => (int) 0,'size' => (int) 0);
        $this->Post->save(array(
            'id'    => 1,
            'thumb_file'   => $file
        ));
        $this->assertEquals(true, file_exists(IMAGES . 'tmp' . DS . 'test1-1.jpg'));
        $this->assertEquals('/img/tmp/test1-1.jpg', $this->Post->field('thumb'));

        // Does en empty file reset the file ?
        $this->Post->save(array(
            'id' => 1,
            'thumb_file' => $file_empty
        ));
        $this->assertEquals(true, file_exists(IMAGES . 'tmp' . DS . 'test1-1.jpg'));
        $this->assertEquals('/img/tmp/test1-1.jpg', $this->Post->field('thumb'));

        // test Auto deletion
        $this->Post->delete();
        $this->assertEquals(false, file_exists(IMAGES . 'tmp' . DS . 'test1-1.jpg'));
    }

	public function testFileUploadWithFieldNotAccepted() {
		$file = array('name' => 'zoidberg.jpg','type' => 'image/jpg','tmp_name' => $this->image,'error' => (int) 0,'size' => (int) 52085);
        $this->Post->save(array(
            'id'    => 1,
            'thumb_file'   => $file
        ), true, array('id'));
        $this->assertEquals(false, file_exists(IMAGES . 'tmp' . DS . 'test1-1.jpg'));
		$this->assertEquals('', $this->Post->field('thumb'));
	}

	/**
	* The goal of this test is to test the deletion of image subformat image_50x50.jpg
	**/
	public function testFileSubformatDeletion(){
		$file = array('name' => 'zoidberg.jpg','type' => 'image/jpg','tmp_name' => $this->image,'error' => (int) 0,'size' => (int) 52085);
        $this->Post->save(array(
            'id'    => 1,
            'thumb_file'   => $file
        ));
        $this->assertEquals(true, file_exists(IMAGES . 'tmp' . DS . 'test1-1.jpg'));
        copy(IMAGES . 'tmp' . DS . 'test1-1.jpg', IMAGES . 'tmp' . DS . 'test1-1_50x50.jpg');
		$this->Post->delete();
        $this->assertEquals(false, file_exists(IMAGES . 'tmp' . DS . 'test1-1.jpg'));
        $this->assertEquals(false, file_exists(IMAGES . 'tmp' . DS . 'test1-1_50x50.jpg'));
	}

	public function testMultipleFieldUpload(){
		$file = array('name' => 'zoidberg.jpg','type' => 'image/jpg','tmp_name' => $this->image,'error' => (int) 0,'size' => (int) 52085);
		$file2 = array('name' => 'zoidberg.png','type' => 'image/png','tmp_name' => $this->imagepng,'error' => (int) 0,'size' => (int) 52085);
        $this->Post->save(array(
            'id'    => 1,
            'thumb_file'   => $file,
            'thumb2_file'   => $file2
        ));
        $this->assertEquals(true, file_exists(IMAGES . 'tmp' . DS . 'test1-1.jpg'));
        $this->assertEquals(true, file_exists(IMAGES . 'tmp' . DS . 'test2-1.png'));
		$this->assertEquals('/img/tmp/test1-1.jpg', $this->Post->field('thumb'));
		$this->assertEquals('/img/tmp/test2-1.png', $this->Post->field('thumb2'));
		$this->Post->delete();
        $this->assertEquals(false, file_exists(IMAGES . 'tmp' . DS . 'test1-1.jpg'));
        $this->assertEquals(false, file_exists(IMAGES . 'tmp' . DS . 'test2-1.png'));
	}

}
