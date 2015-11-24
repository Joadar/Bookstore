<?php echo $this->Form->create('Book', array('type' => 'file')); ?>
	<div class="add">
		<?php echo $this->Form->input('id'); ?>
		<?php echo $this->Form->input('title', array('label' => 'Titre', 'class' => 'form-control')); ?>
		<?php echo $this->Form->input('author_id', array('label' => 'Auteur', 'options' => $authors, 'class' => 'form-control')); ?>
		<?php echo $this->Form->label('description', 'Résumé'); ?>
		<?php echo $this->Form->textarea('description', array('class' => 'form-control', 'rows' => '10')); ?>
		<?php echo $this->Form->input('editor', array('label' => 'Editeur', 'class' => 'form-control')); ?>
		<?php echo $this->Form->input('collection', array('label' => 'Collection', 'class' => 'form-control')); ?>
		<?php echo $this->Form->input('pages', array('type' => 'number', 'label' => 'Nombre de pages', 'class' => 'form-control')); ?>
		<?php echo $this->Form->input('published', array('type' => 'date', 'dateFormat' => 'DMY', 'minYear' => '1800',
        'maxYear' => date('Y'), 'label' => 'Date de publication', 'class' => 'form-control', 'selected' => $this->request->data['Book']['published'])); ?>
  		<?php echo $this->Form->input('genre', array('label' => 'Genre', 'class' => 'form-control')); ?>
		<?php //echo $this->Form->input('picture_file', array('type' => 'file', 'value' => $this->request->data['Book']['picture'], 'label' => 'Première page de couverture', 'class' => 'form-control')); ?>
		<?php echo $this->Form->submit('Modifier', array('class' => 'btn btn-lg btn-primary btn-block')); ?>
	</div>
<?php echo $this->Form->end(); ?>