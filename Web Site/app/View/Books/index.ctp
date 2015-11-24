<?php foreach ($books as $k => $v): ?>

	<?php
		// Partie pour récupérer la note moyenne du livre afin d'afficher les étoiles
		$starNumber = 0;
		
		foreach ($v['Comment'] as $k => $va) {
			$starNumber += $va['rating'];
		}

		if(count($v['Comment']) > 0){
			$starNumber = $starNumber / count($v['Comment']);

			// On affiche les étoiles de note
			$nbStar = "";
			for($x=1;$x<=$starNumber;$x++) {
			    $nbStar .= $this->Html->image('full_star.png');
			}
			if (strpos($starNumber,'.')) {
			    $nbStar .= $this->Html->image('half_star.png');
			    $x++;
			}
			while ($x<=5) {
			    $nbStar .= $this->Html->image('empty_star.png');
			    $x++;
			} 
		} else {
			$nbStar = "";
		}
		
	?>

	<div class="row book_index">
		<div class="col-md-2">
			<?php echo $this->Image->resize($v['Book']['image'], 100, 180); ?>
		</div>
		<div class="col-md-10">
			<h4>
				<?php echo $this->Html->link($v['Book']['title'], array('action' => 'view', $v['Book']['id'])); ?>
				<small>par <?php echo $this->Html->link($v['Author']['firstname'].' '.$v['Author']['lastname'], array('controller' => 'authors', 'action' => 'view', $v['Author']['id']), array('class' => 'author_name')); ?></small>
				<?php if(AuthComponent::user('admin') == true){
					echo $this->Html->link('Editer', array('action' => 'edit', 'admin' => true, $v['Book']['id']), array('class' => 'btn btn-xs btn-success pull-right'));
				} ?>
				<?php echo $nbStar; ?>
			</h4>
			<p><em>Publié le <?php echo $v['Book']['publicationLe']; ?></em></p>
			<p><strong>Résumé : </strong><?php echo $this->Text->truncate($v['Book']['description'], 420, array('ellipsis' => '...', 'exact' => false)); ?></p>
		</div>
	</div>
<?php endforeach ?>

<?php echo $this->Paginator->numbers(array('class' => 'pagination')); ?>