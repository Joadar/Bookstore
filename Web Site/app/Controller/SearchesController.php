<?php 
	class SearchesController extends AppController {

		public function index(){
			if($this->request->is('post')){
				$recherche = $this->request->data['Search']['rechercher'];
				$this->loadModel('Book'); // On charge le model Book

				// On rentre tous les models et leurs champs où faire la recherche
				$tableau = array(
					'Book' => array('fields' => array('title'))
				);

				$phrase = trim($recherche); // On retire les espace avant et après la chaîne de caractère
				$phrase = explode(' ', $phrase); // On explose toute la recherche par les espaces
				$resultat['resultat'] = '';
				foreach ($phrase as $key => $val) { // Pour chaque mot de la recherche
					$resultat['resultat'] = $this->Book->find('all', array(
																	'conditions' => array(
																		'Book.title LIKE' => '%'.strtolower($val).'%'
																	),
																	'recursive' => 1
																)
					);
				}
				$resultat['recherche'] = $recherche;
				$this->set('resultat', $resultat);
			}
		}
	}
?>