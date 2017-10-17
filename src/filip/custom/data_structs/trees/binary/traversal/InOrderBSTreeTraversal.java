package filip.custom.data_structs.trees.binary.traversal;

import filip.custom.data_structs.trees.binary.BSTNode;
import filip.custom.data_structs.trees.binary.BinarySearchTree;
import filip.custom.data_structs.trees.traversal.visitors.SearchTreeNodeVisitor;

/**
 * A class that represents an in-order traversal of a {@link BinarySearchTree}.<br>
 * 
 * This type of traversal visits the node in their ascending order (ordered by the keys).
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in {@link BSTNode} objects.
 * @param <V> Type of values stored in {@link BSTNode} objects.
 */
public class InOrderBSTreeTraversal<K extends Comparable<? super K>, V> implements BSTreeTraversal<K, V> {

	@Override
	public void traverse(BSTNode<K, V> root, SearchTreeNodeVisitor<K, V> visitor) {
		// TODO Auto-generated method stub
		
	}

}
