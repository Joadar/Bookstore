<?php
/**
 * Application level Controller
 *
 * This file is application-wide controller file. You can put all
 * application-wide controller-related methods here.
 *
 * CakePHP(tm) : Rapid Development Framework (http://cakephp.org)
 * Copyright (c) Cake Software Foundation, Inc. (http://cakefoundation.org)
 *
 * Licensed under The MIT License
 * For full copyright and license information, please see the LICENSE.txt
 * Redistributions of files must retain the above copyright notice.
 *
 * @copyright     Copyright (c) Cake Software Foundation, Inc. (http://cakefoundation.org)
 * @link          http://cakephp.org CakePHP(tm) Project
 * @package       app.Controller
 * @since         CakePHP(tm) v 0.2.9
 * @license       http://www.opensource.org/licenses/mit-license.php MIT License
 */

App::uses('Controller', 'Controller');

/**
 * Application Controller
 *
 * Add your application-wide methods in the class below, your controllers
 * will inherit them.
 *
 * @package		app.Controller
 * @link		http://book.cakephp.org/2.0/en/controllers.html#the-app-controller
 */
class AppController extends Controller {

	public $helpers = array('Html', 'Form', 'Image.Image', 'Time');

	public $components = array(
		'Session',
		'Auth'=> array(
			'authenticate' => array(
				'Form' => array(
					'scope' => array('User.active' => 1)
				)
			),
            'authorize',
            'loginAction' => array('controller' => 'users', 'action' => 'login'),
			'loginRedirect' => "/",
			'logoutRedirect' => "/"
        ),
		'Security'
	);
	
	public function beforeFilter() {
        setlocale (LC_TIME, 'fr_FR.utf8','fra');

        $this->Auth->allow('index', 'view', 'home');
	    $this->Auth->authorize = array('Controller');
	    $this->Auth->loginAction = array('controller' => 'users', 'action' => 'login');

        if($this->params->url == "admin" || isset($this->params['prefix']) && $this->params['prefix'] == "admin") {
            if($this->isAuthorized(array('admin' => true))) {
                if ($this->params->url == "admin")
                    $this->redirect('/admin/home');
            } else {
                $this->Session->setFlash("Vous n'avez pas accès à cette section. La modération a été prévenue de votre tentative.", 'admin_error');
                $this->redirect('/');
            }
        }
	}

	public function isAuthorized($options) {
        if(isset($options['admin']) && $options['admin'] == AuthComponent::user('admin')) {
            return true;
        }
	    // Refus par défaut
	    return false;
	}

}
