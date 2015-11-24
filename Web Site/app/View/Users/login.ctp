<div class="add">
	<div class="page-header"><h1>Se connecter</h1></div>
	<?php echo $this->Form->create('User'); ?>
		<?php echo $this->Form->input('username', array('label' => 'Login', 'class' => 'form-control')); ?>
		<?php echo $this->Form->input('password', array('label' => 'Mot de passe', 'class' => 'form-control')); ?>
		<?php echo $this->Form->submit('Connexion', array('class' => 'btn btn-lg btn-primary btn-block')) ?>
	<?php echo $this->Form->end(); ?>
</div>