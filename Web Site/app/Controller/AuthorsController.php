<?php
	
	class AuthorsController extends AppController{

		public function admin_add(){
			if($this->request->is('post')){
				$this->Author->create();
				if($this->Author->save($this->request->data)){
					$this->Session->setFlash(__('Auteur sauvegardé'));
					$this->redirect(array('controller' => 'books', 'action' => 'add'));
				} else {
					$this->Session->setFlash(__('Une erreur est survenue'));
				}
			}
		}

		public function admin_edit($id){
			// Si l'auteur recherché n'existe pas
			if(!$author = $this->Author->findById($id)){
				$this->Session->setFlash(__("L'auteur n'a pas été trouvé"), 'admin_error');
				$this->redirect($this->referer());
			}

			if ($this->request->is('put')) { // Si c'est un put (donc édition)
				$this->Author->create(); // Préparation de l'insertion

				if(empty($this->request->data["Author"]["image_file"]["name"]) && !empty($author["Author"]["image"])){
					$this->request->data["Author"]["image_file"] = $author["Author"]["image"];
				} else if(empty($this->request->data["Author"]["image_file"]["name"]) && empty($author["Author"]["image"])) {
					$this->request->data["Author"]["image"] = "/img/no_image.jpg";
				}

				if ($this->Author->save($this->request->data)) { // Sauvegarde des données de l'auteur
					$this->redirect(array('action' => 'view', $this->Author->id, 'admin' => false));
				}
			}

			$this->request->data = $author;
		}

		public function view($id){
			$this->Author->recursive = 1;

			// Si l'auteur recherché n'existe pas
			if (!$author = $this->Author->findById($id)) {
				$this->Session->setFlash(__("L'auteur n'a pas été trouvé"), 'admin_error');
				$this->redirect($this->referer());
			}

			$this->set('author', $author);
		}
	}
?>