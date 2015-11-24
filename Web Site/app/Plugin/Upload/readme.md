# CakePHP Plugin Upload

[![Build Status](https://travis-ci.org/Grafikart/CakePHP-Upload.png?branch=master)](https://travis-ci.org/Grafikart/CakePHP-Upload)

The main goal of this plugin is to give you the ability to manage file input easily (easy configuration). It was developed specifically for my needs so feel free to do some pull request if you want to add some features (without breaking the tests)

## Requirements

* CakePHP 2.x
* Keyboad + Mouse

## Installation

Load the plugin using bootstrap.php

    CakePlugin::load('Upload');

## Usage

This plugin work as a behaviour for your model so you have to attach it to your model

	public $actsAs = array(
		'Upload.Upload' => array(
			'fields' => array(
				'thumb' => 'img/posts/:id1000/:id'
			)
		)
	);

The fields key is used to define the fields in your table that will be used to save the image path
The value is the path of the uploaded file (within the webroot directory)

* **:id**, record ID
* **:id1000**, ceil( recordID / 1000) * to avoid a single direcoty with thousands of images
* **:id100**
* **:uid** User id (retrieved using CakeSession::read('Auth.User.id'))
* **:y**, year (2013)
* **:m**, month (03)

If you want to create an input to upload a new file you have to name this field ***_file. For the example above :

	$this->Form->input('thumb_file', array('type' => 'file'));

If you save data with this "***_file" field it would automaticaly move the uploaded file to the right directory keeping the extension (using lowercase) and saving the field in your table.

## Validation rules

By default no validation rules are attached to the file upload. **You have to explicity attach a rule to your field or your user could upload any kind of file !**

### fileExtension(Array $authorizedExtensions, $allowEmpty = true)

Check that the file match an array of extensions (lowercase only)

	public $validate = array(
		'thumb_file' => array(
			'rule' => array('fileExtension', array('jpg','png'))
		)
	);

