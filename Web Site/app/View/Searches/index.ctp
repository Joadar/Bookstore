<div class="row">
	<div class="col-md-12 center">
		<h3>Résultats de la recherche pour "<?php echo $resultat['recherche']; ?>"</h3>
	</div>
	
	<?php foreach ($resultat['resultat'] as $k => $v): ?>
		<div class="row book_index">
			<div class="col-md-2">
				<?php echo $this->Image->resize($v['Book']['picture'], 100, 180); ?>
			</div>
			<div class="col-md-10">
				<h4>
					<?php echo $this->Html->link($v['Book']['title'], array('controller' => 'books', 'action' => 'view', $v['Book']['id'])); ?>
					<small>par <?php echo $this->Html->link($v['Author']['firstname'].' '.$v['Author']['lastname'], array('controller' => 'authors', 'action' => 'view', $v['Author']['id']), array('class' => 'author_name')); ?></small>
					<?php if($this->Session->read('Auth.User.admin') == true);{
						echo $this->Html->link('Editer', array('controller' => 'books', 'action' => 'edit', 'admin' => true, $v['Book']['id']), array('class' => 'btn btn-xs btn-success pull-right'));
					} ?>
				</h4>
				<p><em>Publié le <?php echo $v['Book']['publicationDate']; ?></em></p>
				<p><strong>Résumé : </strong><?php echo $this->Text->truncate($v['Book']['description'], 420, array('ellipsis' => '...', 'exact' => false)); ?></p>
				<?php echo $this->Html->link("Réserver à l'achat ".$this->Html->tag('b', $v['Book']['price'])."€ le livre", array('action' => 'bookPurchase', $v['Book']['id']), array('class' => 'btn btn-info', 'escape' => false)); ?>
			</div>
		</div>
	<?php endforeach; ?>
</div>