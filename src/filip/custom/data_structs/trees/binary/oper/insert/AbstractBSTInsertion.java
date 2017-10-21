package filip.custom.data_structs.trees.binary.oper.insert;

import filip.custom.data_structs.trees.binary.BSTNode;
import filip.custom.data_structs.trees.operations.EntryInsertion;

/**
 * A class that represents any insertion to a <b>Binary Search Tree</b>.<br>
 * 
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in a tree.
 * @param <V> Type of values stored in a tree.
 */
public abstract class AbstractBSTInsertion<K extends Comparable<K>, V> implements EntryInsertion<K, V> {
	
	/**
	 * Root of the tree calling this insertion.
	 */
	protected BSTNode<K, V> root;
	
	/**
	 * Whether or not the last call to <code>insert</code> function actually
	 * inserted a new entry.
	 */
	protected boolean inserted;

	/**
	 * Creates a new instance of {@link AbstractBSTInsertion}.
	 * 
	 * @param root Root of the tree this insertion is being called upon.
	 */
	public AbstractBSTInsertion(BSTNode<K, V> root) {
		this.root = root;
		this.inserted = false;
	}
	
	@Override
	public boolean isInserted() {
		return inserted;
	}
}
