# CakePHP Image Helper

The main goal of this plugin is to give you the ability to resize an image without headache.

## Requirements

* CakePHP 2.x
* PHP Gd library 
* Keyboad + Mouse

## Installation

Load the plugin using bootstrap.php

    CakePlugin::load('Image'); 

## Usage

This plugin is a dead simple helper with only one method 

	$this->Image->resize('/img/avatar/1.png', 40, 40)
	// Will generate a resized image /img/avatar/1_40x40.png (transparency is kept)
	// will output 

	<img src="/img/avatar/1_40x40.png" width="40" height="40"/>

The 4th parameter is the same than the 2nd parameter of **HtmlHelper::image()**

If you only want to get the "generated" image path 

	$this->Image->resizedUrl('/img/avatar/1.png', 40, 40); 
