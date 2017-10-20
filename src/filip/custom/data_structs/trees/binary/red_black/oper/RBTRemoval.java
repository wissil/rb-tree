package filip.custom.data_structs.trees.binary.red_black.oper;

import filip.custom.data_structs.trees.binary.red_black.RBTNode;
import filip.custom.data_structs.trees.nodes.SearchTreeNode;
import filip.custom.data_structs.trees.operations.EntryRemoval;

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
public class RBTRemoval<K extends Comparable<K>, V> implements EntryRemoval<K, V> {
	
	/**
	 * Root of the tree calling this removal.
	 */
	private RBTNode<K, V> root;
	
	/**
	 * Value of the entry removed by the last call to method <code>remove</code>.
	 */
	private V removed;
	
	/**
	 * Creates a new instance of {@link RBTRemoval}.
	 * 
	 * @param root Root of the tree calling this removal.
	 */
	public RBTRemoval(RBTNode<K, V> root) {
		this.root = root;
		this.removed = null;
	}

	@Override
	public SearchTreeNode<K, V> remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V getValueRemoved() {
		return removed;
	}

}
