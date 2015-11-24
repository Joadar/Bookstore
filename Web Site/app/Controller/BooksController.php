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
		*	PARTIE RESERVATION
		*/

		// Fonction qui insère le livre dans le panier
		public function bookPurchase($id){
			// Si le livre recherché n'existe pas
			if(!$book = $this->Book->findById($id)){
				$this->Session->setFlash(__('Le livre que vous recherchez n\'existe pas.'), 'admin_error');
			}

			// On charge le model "Reservation"
			$this->loadModel("Reservation");

			// On vérifie si l'utilisateur n'a pas une réservation en attente
			$reservationEnAttente = $this->Reservation->find('count', array('conditions' => array('Reservation.user_id' => $this->Session->read('Auth.User.id'), 'Reservation.done' => false)));
			if($reservationEnAttente > 0){
				$this->Session->setFlash(__('Vous avez déjà une réservation en attente'), 'admin_error');
				$this->redirect($this->referer());
			}

			// On lit la session existante pour les réservations
			$sessionBook = $this->Session->read('Booking');

			// Si le nombre de livre à reserver est supérieur à 3, on affiche un message comme quoi il ne faut pas dépasser 3 livres à réserver
			if(count($sessionBook) >= 3){
				$this->Session->setFlash(__('Vous ne pouvez pas dépasser une réservation de plus de 3 livres'), 'admin_error');
				$this->redirect($this->referer());
			}

			// Si le livre qu'on souhaite réserver à l'achat existe déjà dans le panier, on prévient l'utilisateur
			foreach ($sessionBook as $k => $v) {
				if($v['Book']['id'] == $id){
					$this->Session->setFlash(__('Le livre <b>'.$v['Book']['title'].'</b> est déjà dans votre panier'), 'admin_error');
					$this->redirect($this->referer());
				}
			}

			// On ajoute à la suite du panier de la session le nouveau livre que l'on souhaite ajouter
			$sessionBook[] = $book;
			// On écrit la session
			$this->Session->write('Booking', $sessionBook);
			
			// Si tout c'est passé correctement, on prévient l'utilisateur et on le re-dirige à la page où il se trouvait
			$this->Session->setFlash(__('Le livre a été ajouté à votre panier.'), 'admin_success');
			$this->redirect($this->referer());
		}

		// Fonction qui retire un livre du panier
		public function removeFromCart($id){
			$books = $this->Session->read('Booking');
			$sessionBook = array();
			foreach ($books as $k => $v) {
				if($v['Book']['id'] != $id){
					$sessionBook[] = $v;
				}
			}

			// On écrase la session existante avec le livre en moins
			$this->Session->write('Booking', $sessionBook);

			$this->redirect($this->referer());
		}

		public function cart(){
			$books = $this->Session->read('Booking');
			$id = array();

			// S'il y a quelque chose dans la session
			if(count($books) != 0){
				// On récupère l'id des livres et le prix total
				foreach ($books as $k => $v) {
					$id[] = $v['Book']['id'];
					$this->total_price += $v['Book']['price'];
				}

				$this->Book->recursive = 1;
				// On recherche tous les livres correspondants aux id données, ça retourne aussi les auteurs respectifs
				$books = $this->Book->find('all', array('conditions' => array('Book.id' => $id)));
			} else{
				$this->total_price = 0;
				$books = 0;
			}

			$this->set('total_price', $this->total_price);
			$this->set('books', $books);
		}

		public function summaryCart(){
			$this->cart();

			$this->price_ttc = round($this->total_price + ($this->total_price * 20 / 100), 2); // round(double, 2) : fonction qui retourne la valeur la plus proche à deux chiffres après la virgule
			$this->set('ttc', $this->price_ttc);
		}

		// Réserver les livres (ajout dans la BDD)
		public function reserveBooks(){
			$this->summaryCart();

			// On charge le model "Reservation"
			$this->loadModel("Reservation");

			// On vérifie si l'utilisateur n'a pas une réservation en attente
			$reservationEnAttente = $this->Reservation->find('count', array('conditions' => array('Reservation.user_id' => $this->Session->read('Auth.User.id'), 'Reservation.done' => false)));
			if($reservationEnAttente > 0){
				$this->Session->setFlash(__('Vous avez déjà une réservation en attente'), 'admin_error');
				$this->redirect('/');
			}

			// On prépare les données à insérer dans la table "Reservations"
			$this->request->data['Reservation']['user_id'] = $this->Session->read('Auth.User.id');
			$this->request->data['Reservation']['price_ttc'] = $this->price_ttc;

			// On enregistre les données dans la table "Reservations" à partir du model chargé précédemment
			if($this->Reservation->save($this->request->data)){
				$this->Session->setFlash(__('Réservation réussie'), 'admin_success');
			} else {
				$this->Session->setFlash(__('Une erreur est survenue lors de la création de la réservation'), 'admin_error');
			}

			// On récupère tous les livres de la réservation
			$books = $this->Session->read('Booking');
			foreach ($books as $k => $v) {
				// On insère pour chaque livre l'id de réservation auquel il est attaché et son id à lui
				$data[] = array('reservation_id' =>  $this->Reservation->getLastInsertID(), 'book_id' => $v['Book']['id']);
			}

			if($this->Reservation->ReservationBook->saveAll($data)){
					$this->Session->setFlash(__('Insertion des livres réservés réussie'), 'admin_success');
			} else {
					$this->Session->setFlash(__('Une erreur est survenue lors de l\'insertion des livres réservés'), 'admin_error');
			}

			// On envoit un email qui résume sa commande
			App::uses('CakeEmail', 'Network/Email'); 
			$mail = new CakeEmail('gmail');
			$mail->from(array('jonathan.pannetier@gmail.com' => 'Jonathan'))
				->to($this->Session->read('Auth.User.email'))
				->subject('BookStore :: Votre réservation')
				->emailFormat('html')
				->template('reservation')
				->viewVars(array('username' => $this->Session->read('Auth.User.username'), 'books' => $books, 'total_price' => $this->total_price, 'ttc' => $this->price_ttc))
				->send();

			$this->Session->setFlash(__('Un email récapitulatif vous a été envoyé'), 'admin_success');

			$this->loadModel("User");
			$reservation = $this->User->Reservation->find('first', array('conditions' => array('Reservation.user_id' => $this->User->id, 'Reservation.done' => false)));

		    $this->Session->write('reservation', $reservation);
			$this->redirect('/');	
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