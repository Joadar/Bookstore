<?php

	class Book extends AppModel{

		public $name = "Book";
		public $belongsTo = array(
			'Author' =>  array(
	            'className'     => 'Author',
	            'foreignKey'    => 'author_id'
	        )
	    );

	    public $hasMany = array(
	    	'Comment'
	    );

	    public $actsAs = array(
		    'Upload.Upload' => array(
		        'fields' => array(
		            'image' => 'img/books/:id1000/:id'
		        )
		    )
		);

		public $validate = array(
		    'title' => 'notEmpty',
			'description' => 'notEmpty',
			'editor' => 'notEmpty',
			'pages' => 'notEmpty',
			'published' => 'notEmpty',
			'genre' => 'notEmpty',
			'language' => 'notEmpty',
			'image_file' => array(
		        'rule' => array('fileExtension', array('jpg','png'))
		    )
		);

		public function afterFind($results, $primary = false){

			// Mettre la date en Français
			$month = array("Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre");
			foreach ($results as $k => $v){
				if(isset($v['Book'])){
					$date = new Datetime($v['Book']['published']);
					$results[$k]['Book']['publicationLe'] = $date->format('d').' '.$month[$date->format('n') - 1].' '.$date->format('Y');
				}
			}

			return $results;
		}
	}

?>