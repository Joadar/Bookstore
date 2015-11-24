<?php

	class UsersController extends AppController{

		public function beforeFilter() {
	        parent::beforeFilter();
	        $this->Auth->allow('add');
	    }

		public function login() {
			if($this->Auth->loggedIn()) {			
				throw new MethodNotAllowedException(__('This action is impossible.'));
			}
		    if ($this->request->is('post')) {
                $this->request->data["User"]['password'] = sha1(md5($this->request->data["User"]['password']));

                $user = $this->User->find("all", array("conditions" => array("username" => $this->request->data["User"]['username'], "password" => $this->request->data["User"]['password'])));

                if (!empty($user)) {
                    unset($user[0]['User']['password']);
                    $this->Auth->login($user[0]["User"]);
		        	$this->User->id = $this->Auth->user('id');

		            $this->redirect('/');
		        } else {
		            $this->Session->setFlash(__('The username or password is wrong'), 'admin_error');
	       		}
	    	}
		}

		// Fonction déconnexion
		public function logout() {
			$this->Session->destroy();
			$this->redirect($this->Auth->logout());
		}

		// Fonction inscription
		public function add(){
			if($this->Auth->loggedIn()){
				throw new MethodNotAllowedException(__('This action is impossible.'));
			}
			if($this->request->is('post')){
				$this->User->create();
				if($this->User->save($this->request->data)){
					$this->Session->setFlash(__('The user has been saved.'));
					$this->redirect(array('controller' => '', 'action' => 'index'));
				} else {
					$this->Session->setFlash(__('The user could not be saved. Please, try again'));
				}
			}
		}

		// Fonction pour éditer son compte
		public function edit(){
			$this->User->id = $this->Session->read('Auth.User.id');
			$user = $this->User->findById($this->User->id);
			if ($this->request->is('put')) { // Si c'est un put (donc édition)
				$this->User->create(); // Préparation de l'insertion
				if ($this->User->save($this->request->data)) { // Sauvegarde des données du membre
					$this->Session->write('Auth.User.username', $this->request->data['User']['username']);
					$this->Session->setFlash("Modification du profil effectué");
					$this->redirect('/');
				}
			}

			$this->request->data = $user;
		}

		public function view($id){
			if (!$user = $this->User->findById($id)) {
				$this->Session->setFlash(__("L'utilisateur n'existe pas"), 'admin_error');
				$this->redirect($this->referer());
			}
		}
	}
?>