package filip.custom.data_structs.trees.binary.red_black.oper.remove;

import filip.custom.data_structs.trees.binary.red_black.RBTNode;
import filip.custom.data_structs.trees.nodes.SearchTreeNode;

/**
 * A class that represents a removal of element from a <b>Red-Black Tree</b>.<br>
 * 
 * The actual algorithm that performs the removal is implemented here.
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in a tree.
 * @param <V> Type of values stored in a tree.
 */
public class RBTRemoval<K extends Comparable<K>, V> extends AbstractRBTRemoval<K, V> {
		
	/**
	 * Creates a new instance of {@link RBTRemoval}.
	 * 
	 * @param root Root of the tree calling this removal.
	 */
	public RBTRemoval(RBTNode<K, V> root) {
		super(root);
	}

	@Override
	public SearchTreeNode<K, V> remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}
}
