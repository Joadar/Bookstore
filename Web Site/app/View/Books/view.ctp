<?php
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

	if($starNumber == 0)
		$nbStar = "";
?>

<div class="row">
	<div class="col-md-4">
		<?php echo $this->Image->resize($book['Book']['image'], 300, 475); ?>
	</div>
	<div class="col-md-8">
		<h3><?php echo $book['Book']['title']; ?>
			<?php if(AuthComponent::user('admin') == true){
			echo $this->Html->link('Editer', array('action' => 'edit', 'admin' => true, $book['Book']['id']), array('class' => 'btn btn-xs btn-success pull-right'));
		} ?> <?php echo $nbStar; ?> </h3>

		<p><strong>Date de publication : </strong> <?php echo $book['Book']['publicationLe']; ?> </p>
		<p><strong>Auteur : </strong><?php echo $this->Html->link($book['Author']['firstname'].' '.$book['Author']['lastname'], array('controller' => 'authors', 'action' => 'view', $book['Author']['id'])); ?></p>
		<p><strong>Pages : </strong><?php echo $book['Book']['pages']; ?></p>
		<p><strong>Editeur : </strong><?php echo $book['Book']['editor']; ?></p>
		<!--<p><strong>Langue : </strong><?php echo $book['Book']['language']; ?></p>
		<p><strong>Collection : </strong><?php echo $book['Book']['collection']; ?></p>-->
		<p><strong>Genre : </strong><?php echo $book['Book']['genre']; ?></p>
		<p><strong>Résumé : </strong><?php echo $book['Book']['description']; ?></p>

		<!-- Partie commentaire du livre -->
		<hr>
		<div class="row">
			<div class="col-md-12">
				<h4 class="center"> Commentaires</h4>
				<?php echo $this->Html->link('Ajouter un commentaire', '#', array('class' => 'btn btn-success btn-add-comment float_right')); ?>
			</div>
		</div>
		<div class="row form_comment">
			<div class="col-md-12">
				<?php echo $this->Form->create('Comment', array('controller' => 'comments', 'action' => 'add')); ?>
				<?php echo $this->Form->input('rating', array('label' => 'Note', 'options' => array('0', '1', '2', '3', '4', '5'), 'class' => 'form-control')); ?>
				<?php echo $this->Form->label('content', 'Message'); ?>
				<?php echo $this->Form->textarea('content', array('class' => 'form-control', 'rows' => '10')); ?>
				<?php echo $this->Form->input('user_id', array('type' => 'hidden', 'value' => $this->Session->read('Auth.User.id'))); ?>
				<?php echo $this->Form->input('book_id', array('type' => 'hidden', 'value' => $book['Book']['id'])); ?>
				<br>
				<?php echo $this->Form->submit('Envoyer votre avis', array('class' => 'btn btn-success float_right')); ?>
				<?php echo $this->Form->end(); ?>
			</div>
		</div>
		<div class="row show_comment">
			<div class="col-md-12">
				<?php foreach ($book['Comment'] as $k => $v): ?>
				<?php 
					$nbStar = "";
					for($x=1;$x<=$v['rating'];$x++) {
					    $nbStar .= $this->Html->image('full_star.png');
					}
					if (strpos($v['rating'],'.')) {
					    $nbStar .= $this->Html->image('half_star.png');
					    $x++;
					}
					while ($x<=5) {
					    $nbStar .= $this->Html->image('empty_star.png');
					    $x++;
					}
				?>
					<p>Publié par <b><?php echo $v['User']['username']; ?></b> le <?php echo strftime("%d/%m/%Y à %H:%M", strtotime($v['created'])); ?> | 
					<?php echo $nbStar; ?></p>
					<?php echo $v['content']; ?>
					<hr>
				<?php endforeach ?>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
$('.btn-add-comment').click(function(){
	$('.form_comment').toggle();
	event.preventDefault();
});</script>
