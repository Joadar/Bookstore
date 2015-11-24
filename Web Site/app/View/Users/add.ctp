<?php echo $this->Form->create('User'); ?>
	<div class="add">
		<h1 class="center">Inscription</h1>
		<?php echo $this->Form->input('username', array('label' => 'Login', 'class' => 'form-control')); ?>
		<?php echo $this->Form->input('password', array('label' => 'Mot de passe', 'class' => 'form-control')); ?>
		<?php echo $this->Form->input('check_password', array('label' => 'Répéter le mot de passe', 'type' => 'password', 'class' => 'form-control')); ?>
		<?php echo $this->Form->input('email', array('label' => 'Email', 'type' => 'email', 'class' => 'form-control')); ?>
		<?php echo $this->Form->input('check_email', array('label' => 'Répéter l\'email', 'type' => 'email', 'class' => 'form-control')); ?>
		<?php echo $this->Form->input('sexe', array('label' => 'Sexe', 'between' => '|', 'options' => array('M' => 'M', 'F' => 'F'), 'class' => 'form-control')); ?>
		<?php echo $this->Form->submit('S\'enregistrer', array('class' => 'btn btn-lg btn-primary btn-block')); ?>
	</div>
<?php echo $this->Form->end(); ?>					
