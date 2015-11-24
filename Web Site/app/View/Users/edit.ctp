<?php echo $this->Form->create('User'); ?>
	<div class="add">
		<h1 class="center">Modification du compte</h1>
		<?php echo $this->Form->input('username', array('label' => 'Login', 'class' => 'form-control')); ?>
		<?php echo $this->Form->input('firstname', array('label' => 'Prénom', 'class' => 'form-control')); ?>
		<?php echo $this->Form->input('lastname', array('label' => 'Nom', 'class' => 'form-control')); ?>
		<?php echo $this->Form->input('adress', array('label' => 'Adresse', 'class' => 'form-control')); ?>
		<?php echo $this->Form->input('city', array('label' => 'Ville', 'class' => 'form-control')); ?>
		<?php echo $this->Form->input('PC', array('label' => 'Code Postal', 'class' => 'form-control')); ?>
		<?php echo $this->Form->input('sexe', array('label' => 'Sexe', 'between' => '|', 'options' => array('M' => 'M', 'F' => 'F'), 'class' => 'form-control')); ?>
		<?php echo $this->Form->input('id'); ?>
		<?php echo $this->Form->submit('Modifier le compte', array('class' => 'btn btn-lg btn-primary btn-block')); ?>
	</div>
<?php echo $this->Form->end(); ?>					
