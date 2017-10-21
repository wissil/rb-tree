package filip.custom.data_structs.trees.binary.oper.remove;

import filip.custom.data_structs.trees.binary.BSTNode;
import filip.custom.data_structs.trees.operations.EntryRemoval;

/**
 * A class that represents any type of removal of an element from a <b>Binary Search Tree</b>.<br>
 * 
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in a tree.
 * @param <V> Type of values stored in a tree.
 */
public abstract class AbstractBSTRemoval<K extends Comparable<K>, V> implements EntryRemoval<K, V> {

	/**
	 * Root of the tree calling this removal.
	 */
	protected BSTNode<K, V> root;
	
	/**
	 * Value of the entry removed by the last call to method {@link #remove(K)}.
	 */
	protected V removed;
	
	/**
	 * Creates a new instance of {@link AbstractBSTRemoval}.
	 * 
	 * @param root Root of the tree this removal is called upon.
	 */
	public AbstractBSTRemoval(BSTNode<K, V> root) {
		this.root = root;
		this.removed = null;
	}
	
	@Override
	public V getValueRemoved() {
		return removed;
	}
}
