<?php

	class Author extends AppModel{

		public $displayField = "firstname";
		public $hasMany = array('Book');

		public $validate = array(
			'firstname' => 'notEmpty',
			'lastname' => 'notEmpty'
		);
	}

?>