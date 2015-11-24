<?php
	class User extends AppModel{

		public $hasMany = array(
			'Reservation',
			'Comment'
		);

		public $validate = array(
			'username' => array(
				'login' => array(
					'rule' => 'isUnique',
					'message' => 'Le membre existe déjà'
				),
				'pattern' => array(
                    'rule' => array('custom','/^[a-zA-Z0-9_]+$/i'),
                    'message' => 'Le pseudo doit comprendre seulement des lettres ou des chiffres',
            	),
            	'length' => array(
					'rule' => array('between', 3, 15),
					'message' => 'Le pseudo doit comprendre entre 3 et 15 caractères'
				)
			),
           	'password' => array(
           		'match' => array(
		            //'rule' => array('match', 'password_confirm'),
		            'rule' => 'notEmpty',
		            'message' => 'Les mots de passe ne correspondent pas',
		        ),
       			 'length' => array(
	                'rule' => array('minLength', '5'),
	                'message' => 'Votre mot de passe doit comprendre au moins cinq caractères'
                )
            ),
            'check_password' => array(
           		'match' => array(
		            'rule' => array('match', 'password'),
		            'message' => 'Les mots de passe ne correspondent pas',
		        ),
       			 'length' => array(
	                'rule' => array('minLength', '5'),
	                'message' => 'Votre mot de passe doit comprendre au moins cinq caractères'
                )
            ),
            'email' => array(
				'email' => array(
					'rule' => array('email'),
					'message' => 'Votre adresse mail ne correspond pas aux normes',
					'allowEmpty' => false,
				),
				'unique' => array(
					'rule' => 'isUnique',
					'message' => 'Cette adresse mail existe déjà',
					'allowEmpty' => false
				)
			),
			'check_email' => array(
				'email' => array(
					'rule' => array('email'),
					'message' => 'Votre adresse mail ne correspond pas aux normes',
					'allowEmpty' => false,
				),
           		'match' => array(
		            'rule' => array('match', 'email'),
		            'message' => 'Les emails ne correspondent pas',
		        )
            ),			
            'firstname' => 'notEmpty',
			'lastname' => 'notEmpty',
			'adress' => 'notEmpty',
			'city' => 'notEmpty',
			'PC' => 'notEmpty',
			'sexe' => 'notEmpty'
		);

		public function beforeSave($options = NULL) {
			//Génération du password crypté.
			if(isset($this->data['User']['password']) && !empty($this->data['User']['password'])){
				unset($this->data['User']['check_password']);
				//$this->data['User']['password'] = AuthComponent::password($this->data['User']['password']);
				$this->data['User']['password'] = sha1(md5($this->data['User']['password']));
				//Génération de la private_key			
				$key = time() * rand(99999, 999999) * rand(999999, 9999999);
				//$key .= $this->data['User']['username'];
			}
			return true;
		}

		public function match($check, $with) {
		    // Getting the keys of the parent field
		    foreach ($check as $k => $v) {
		        $$k = $v;
		    }

		    // Removing blank fields
		    $check = trim($$k);
		    $with = trim($this->data[$this->name][$with]);

		    // If both arent empty we compare and return true or false
		    if (!empty($check) && !empty($with)) {
		        return $check == $with;
		    }

		    // Return false, some fields is empty
		    return false;
		}

	}