<?php
	
	Class CommentsController extends AppController{

		// Fonction qui permet d'ajouter un commentaire
		public function add(){
			if($this->request->is('post')) {
				$this->Comment->create();
				if ($this->Comment->save($this->request->data)) {
					$this->Session->setFlash(__('Commentaire envoyé'), 'admin_success');
				} else {
					$this->Session->setFlash(__('Une erreur est survenue lors de l\'envoi du commentaire'), 'admin_error');
				}

				$this->redirect($this->referer()); // On redirige l'utilisateur là où il se trouvait avant cette fonction
			}
		}

		// Fonction qui permet de voir tous les commentaires du livre correspondant
		public function view($id){
			// On souhaite récupérer aussi les données propres à l'utilisateurs donc on va chercher plus rien : recursive à 2
			$this->Comment->Book->recursive = 2;
			if(!$book = $this->Comment->Book->findById($id)){
				$this->Session->setFlash(__('Livre introuvable'), 'admin_error');
				$this->Redirect('/');
			}

			return $book; // On retourne le livre récupéré
		}
	}