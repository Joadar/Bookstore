<?php

	class Author extends AppModel{

		public $displayField = "firstname";
		public $hasMany = array('Book');

        public $actsAs = array(
            'Upload.Upload' => array(
                'fields' => array(
                    'image' => 'img/authors/:id1000/:id'
                )
            )
        );

		public $validate = array(
			'firstname' => 'notEmpty',
			'lastname' => 'notEmpty',
			'image_file' => array(
				'rule' => array('fileExtension', array('jpg','png', 'jpeg')),
                'allowEmpty' => true
			)
		);
	}

?>