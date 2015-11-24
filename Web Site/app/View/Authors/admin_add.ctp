<?php echo $this->Form->create('Author'); ?>
	<div class="add">
	<?php echo $this->Form->input('firstname', array('label' => 'Prénom', 'class' => 'form-control')); ?>
	<?php echo $this->Form->input('lastname', array('label' => 'Nom', 'class' => 'form-control')); ?>
	<?php echo $this->Form->label('biography', 'Biographie'); ?>
	<?php echo $this->Form->textarea('biography', array('class' => 'form-control', 'rows' => '10')); ?>
	<?php echo $this->Form->submit('Ajouter', array('class' => 'btn btn-lg btn-primary btn-block')); ?>
	</div>
<?php echo $this->Form->end(); ?>