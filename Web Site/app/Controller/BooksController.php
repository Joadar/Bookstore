<?php
	App::import('Controller', 'Comments'); // On met en relation avec un autre controller

	class BooksController extends AppController{

		public $total_price; // On déclare une variable gloable
		public $price_ttc; // On déclare une variable globale

	    public $components = array('Paginator'); // On intégre le composant "paginator"

	    public $paginate = array(
	        'limit' => 7, // On limite la pagination à 7 éléments par page
	        'order' => array('Book.id' => 'DESC')
	    );

		public function index(){
			$this->Book->recursive = 1; // La récursivité est à 1
			$this->Paginator->settings = $this->paginate;

            $books = $this->Paginator->paginate('Book'); // On veut paginer sur le modèle "Book"
            $this->set('books', $books); 
		}

		public function admin_add(){
			if($this->request->is('post')){
				$this->Book->create();
				if($this->Book->save($this->request->data)){
					$this->Session->setFlash(__('Le livre a été ajouté'), 'admin_success');
					$this->redirect(array('action' => 'index', 'admin' => false)); // On redirige l'utilisateur sur l'action index du controller actuel
				} else {
					$this->Session->setFlash(__('Une erreur est survenue, veuillez essayer de nouveau'), 'admin_error');
				}
			}
			$this->getAuthors();
		}

		public function admin_edit($id){
			$this->Book->id = $id;
			if(!$book = $this->Book->findById($id)){ // Si l'id du livre recherché n'existe pas
				$this->Session->setFlash(__('Le livre que vous recherchez n\'existe pas.'), 'admin_error');
				$this->redirect($this->referer());
			}

			if ($this->request->is('put')) { // Si c'est un put (donc édition)
				$this->Book->create(); // Préparation de l'insertion
				if ($this->Book->save($this->request->data)) { // Sauvegarde des données du livre
					$this->redirect(array('action' => 'view', $this->Book->id, 'admin' => false));
				}
			}

			$this->request->data = $book;
			$this->getAuthors();
		}

		public function view($id){
			$this->Book->recursive = 1;
			// Si le livre recherché n'existe pas
			if(!$book = $this->Book->findById($id)){
				$this->Session->setFlash(__('Le livre que vous recherchez n\'existe pas.'), 'admin_error');
				$this->redirect($this->referer());
			}

			// Partie pour récupérer la note moyenne du livre afin d'afficher les étoiles
			$starNumber = 0;
		
			foreach ($book['Comment'] as $k => $v) {
				$starNumber += $v['rating'];
			}

			if(count($book['Comment']) != 0)
				$starNumber = $starNumber / count($book['Comment']);
			else
				$starNumber = 0;
			$this->set('starNumber', $starNumber);

			$Comment = new CommentsController; // On instancie l'objet CommentsController
			$book = $Comment->view($id); // On appel la fonction souhaité
			$this->set('book', $book);
		}


	   /*
		*	FONCTIONS PRIVEES
		*/

		private function getAuthors(){
			$toSend = $this->Book->Author->find('all', array('order' => array('firstname', 'lastname'))); // On récupère tous les auteurs trié par prénom et nom
			$authors = array();
			foreach ($toSend as $k => $v) {
				// On met en place un tableau pour afficher les auteurs
				$authors += array($v['Author']['id'] => $v['Author']['firstname']. ' '. $v['Author']['lastname']);
			}
			// On envois le tableau
			$this->set('authors', $authors);
		}
	}