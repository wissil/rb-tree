package filip.custom.data_structs.trees.binary.red_black.oper.remove;

import filip.custom.data_structs.trees.binary.red_black.RBTNode;
import filip.custom.data_structs.trees.operations.EntryRemoval;

/**
 * A class that represents any type removal of an element from a <b>Red-Black Tree</b>.<br>
 * 
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in a tree.
 * @param <V> Type of values stored in a tree.
 */
public abstract class AbstractRBTRemoval<K extends Comparable<K>, V> implements EntryRemoval<K, V> {
	
	/**
	 * Root of the tree calling this removal.
	 */
	protected RBTNode<K, V> root;
	
	/**
	 * Value of the entry removed by the last call to method {@link #remove(K)}.
	 */
	protected V removed;

	/**
	 * Creates a new instance of {@link AbstractRBTRemoval}.
	 * 
	 * @param root Root of the tree this removal is being called upon.
	 */
	public AbstractRBTRemoval(RBTNode<K, V> root) {
		this.root = root;
		this.removed = null;
	}
	
	@Override
	public V getValueRemoved() {
		return removed;
	}
}
