package filip.custom.data_structs.trees.binary.oper.remove;

import filip.custom.data_structs.trees.binary.BSTNode;
import filip.custom.data_structs.trees.nodes.SearchTreeNode;

/**
 * A class that represents an iterative removal of element from a <b>Binary Search Tree</b>,
 * as opposed to recursive removal.<br>
 * 
 * The actual algorithm that performs the removal is implemented here.
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in a tree.
 * @param <V> Type of values stored in a tree.
 */
public class BSTIterRemoval<K extends Comparable<K>, V> extends AbstractBSTRemoval<K, V> {

	/**
	 * Creates a new instance of {@link BSTIterRemoval}.
	 * 
	 * @param root Root of the tree this removal is called upon.
	 */
	public BSTIterRemoval(BSTNode<K, V> root) {
		super(root);
	}

	@Override
	public SearchTreeNode<K, V> remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

}
