<div class="row">
	<div class="col-md-12">
		<?php if(AuthComponent::user('admin') == true){
			echo $this->Html->link('Editer', array('action' => 'edit', 'admin' => true, $author['Author']['id']), array('class' => 'btn btn-xs btn-success pull-right'));
		} ?>
		<p><strong>Prénom : </strong><?php echo $author['Author']['firstname']; ?></p>
		<p><strong>Nom : </strong><?php echo $author['Author']['lastname']; ?></p>
		<p><strong>Biographie : </strong><?php echo ($author['Author']['biography'] != null) ? nl2br($author['Author']['biography']) : "Pas de biographie disponible"; ?> </p>
	</div>
</div>

<div class="row">
	<div class="col-md-12 center"><h3>Les autres livres de l'auteur</h3></div>
</div>

<?php 
	$i = 1; $count = count($author['Book']);
	foreach ($author['Book'] as $k => $v): ?>
		<?php if ($i%5 == 1): ?>
			<div class="row center">
		<?php endif; ?>
			<div class="col-md-4">
				<?php echo $this->Html->link($this->Image->resize($v['image'], 100, 180), array('controller' => 'books', 'action' => 'view', $v['id']), array('escape' => false)); ?>
			</div>
		<?php if ($i%5 == 0 OR $i == $count): ?>
			</div>
		<?php endif ?>
		<?php $i++; ?>
<?php endforeach ?>

