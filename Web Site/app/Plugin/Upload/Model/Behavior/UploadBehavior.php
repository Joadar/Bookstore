<?php
class UploadBehavior extends ModelBehavior{

    /**
    * Fields is used to define fields that are "uploadable"
    * array(
    *   'avatar' => 'img/:id'
    * )
    *
    * :id     => Record ID
    * :id1000 => ceil( Record ID / 1000 )
    * :id100  => ceil( Record ID / 100 )
    * :y      => year
    * :m      => month
    * :uid    => user id (Auth.User.id)
    * :md5    => random MD5
    **/
    private $defaultOptions = array(
        'fields' => array()
    );
    private $options = array();

    public function setup(Model $model, $config = array()){
        $this->options[$model->alias] = array_merge($this->defaultOptions, $config);
    }

    /**
    * CakePHP Model Functions
    **/
    public function afterSave(Model $model, $created, $options = array()){
        $data = $model->data;
        foreach($this->options[$model->alias]['fields'] as $field => $path){
           if(
                isset($data[$model->alias][$field . '_file']) &&
                !empty($data[$model->alias][$field . '_file']['name']) &&
                (
                    !$model->whitelist ||
                    empty($model->whitelist) ||
                    in_array($field, $model->whitelist)
                )
            ){
                $file = $data[$model->alias][$field . '_file'];
                $extension = strtolower(pathinfo($file['name'], PATHINFO_EXTENSION));
                $path = $this->getUploadPath($model, $path, $extension);
                $dirname = dirname($path);
                if(!file_exists(WWW_ROOT . $dirname)){
                    mkdir(WWW_ROOT . $dirname, 0777, true);
                }
                $model->deleteOldUpload($field);
                $model->move_uploaded_file(
                    $file['tmp_name'],
                    WWW_ROOT . $path
                );
                chmod(WWW_ROOT . $path, 0777);
                $model->saveField($field, '/' . $path);
           }
        }
    }

    public function beforeDelete(Model $model, $cascade = true){
        foreach($this->options[$model->alias]['fields'] as $field => $path){
            $model->deleteOldUpload($field);
        }
        return true;
    }

    /**
     * Alias for the move_uploaded_file function, so it can be mocked for testing purpose
    */
    public function move_uploaded_file(Model $model, $source, $destination){
        move_uploaded_file($source, $destination);
    }

    /**
     * Custom Validation Rules
     */
    public function fileExtension(Model $model, $check, $extensions, $allowEmpty = true){
        $file = current($check);
        if($allowEmpty && empty($file['tmp_name'])){
            return true;
        }
        $extension = strtolower(pathinfo($file['name'] , PATHINFO_EXTENSION));
        return in_array($extension, $extensions);
    }

    /**
    * MISC
    **/
    private function getUploadPath(Model $model, $path, $extension){
        $path = trim($path, '/');
        $replace = array(
            ':id1000'  => ceil($model->id / 1000),
            ':id100'   => ceil($model->id / 100),
            ':id'      => $model->id,
            ':y'       => date('Y'),
            ':m'       => date('m'),
            ':uid'     => CakeSession::read('Auth.User.id'),
            ':md5'     => md5(rand() . uniqid() . time())
        );
        $path = strtr($path, $replace) . '.' . $extension;
        return $path;
    }

    public function deleteOldUpload(Model $model, $field){
        $file = $model->field($field);
        if(empty($file)){
            return true;
        }
        $info = pathinfo($file);
        $subfiles = glob(WWW_ROOT . $info['dirname'] . DS . $info['filename'] . '_*x*.*');
        if(file_exists(WWW_ROOT . $file)){
            unlink(WWW_ROOT . $file);
        }
        if($subfiles){
            foreach($subfiles as $file){
                unlink($file);
            }
        }
    }


}
