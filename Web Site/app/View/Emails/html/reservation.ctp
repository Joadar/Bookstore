Bonjour <strong><?php echo $username; ?></strong>, voici un récapitulatif de votre commande : 
<table>
	<?php foreach ($books as $k => $v): ?>

		<?php $link = array('controller' => 'books', 'action' => 'view', $v['Book']['id']); ?>
		
		<tr>
			<td><?php echo $this->Html->link($v['Book']['title'], $this->Html->url($link, true)); ?></td>
			<td><?php echo $v['Book']['price']; ?>€</td>
		</tr>

	<?php endforeach; ?>

	<tr style="text-align:right"><td colspan="2">Prix total : <b><?php echo $total_price; ?></b></td></tr>
	<tr style="text-align:right"><td colspan="2">TVA : <b>20%</b></td></tr>
	<tr style="text-align:right"><td colspan="2">Prix TTC : <b><?php echo $ttc; ?></b></td></tr>
</table>