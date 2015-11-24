<div class="navbar navbar-default navbar-fixed-top" role="navigation">
  <div class="container">

    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <?php echo $this->html->link("Bookstore", '/', array('class' => 'navbar-brand')); ?>
    </div>

    <div class="navbar-collapse collapse">
      
      <!-- On déclare le formulaire de recherche au début de la partie gauche du menu -->
      <?php echo $this->Form->create('Search', array('controller' => 'searches', 'action' => 'index')); ?>
      <ul class="nav navbar-nav">
        <?php if ($this->Session->read('Auth.User.admin') == false): ?>
          <li class="active"><?php echo $this->html->link("Livres", array('controller' => 'books', 'action' => 'index')); ?></li>
        <?php else: ?>
          <li class="dropdown">
            <?php echo $this->html->link("Livres ". $this->Html->tag('b', '', array('class' => 'caret')), '#', array('class' => 'dropdown-toggle', 'data-toggle' => 'dropdown', 'escape' => false)); ?>
            
            <!-- Sous menu -->
            <ul class="dropdown-menu">
              <li><?php echo $this->Html->link("Voir les livres", array('controller' => 'books', 'action' => 'index', 'admin' => false)); ?></li>
              <li><?php echo $this->Html->link('Ajouter un livre', array('controller' => 'books', 'action' => 'add', 'admin' => true)); ?></li>
              <li class="divider"></li>
              <li class="dropdown-header">Auteur</li>
              <li><?php echo $this->Html->link('Ajouter un auteur', array('controller' => 'authors', 'action' => 'add', 'admin' => true)); ?></li>
            </ul>

          </li>
          <?php
            echo $this->Form->unlockField('Search.rechercher');
            echo '<li>'. $this->Form->input('rechercher', array('id' => 'appendedInputButton', 'placeholder' => 'Rechercher un livre...', 'autocomplete' => 'off', 'label' => false, 'div' => false, 'class' => 'form_search form-control')) .'</li>';
            echo '<li>'. $this->Form->submit('Rechercher', array('class' => 'form_search btn btn-default')) .'</li>';
          ?>
        <?php endif ?>
      </ul> 
      <?php echo $this->Form->end(); ?>

      <!-- Partie droite du menu -->
      <ul class="nav navbar-nav navbar-right">
        
        <?php if ($this->Session->read('Auth.User')): ?>

          <li><?php echo $this->Html->link('Panier | '. count($this->Session->read('Booking')) .' livre(s)', array('controller' => 'books', 'action' => 'cart', 'admin' => false)); ?></li>

          <li class="dropdown active">
            <?php echo $this->html->link($this->Session->read('Auth.User.username').' '.$this->Html->tag('b', '', array('class' => 'caret')), '#', array('class' => 'dropdown-toggle', 'data-toggle' => 'dropdown', 'escape' => false)); ?>
            
            <!-- Sous menu -->
            <ul class="dropdown-menu">
              <li><?php echo $this->Html->link("Mon profil", array('controller' => 'users', 'action' => 'edit', 'admin' => false)); ?></li>
              <li><?php echo $this->Html->link('Déconnexion', array('controller' => 'users', 'action' => 'logout', 'admin' => false)); ?></li>
            </ul>

          </li>

        <?php else: ?>
          <li><?php echo $this->Html->link("Se connecter", array('controller' => 'users', 'action' => 'login')); ?></li>
          <li><?php echo $this->Html->link("S'inscrire", array('controller' => 'users', 'action' => 'add')); ?></li>
        <?php endif ?>
      </ul>

    </div><!--/.nav-collapse -->
  </div>
</div>