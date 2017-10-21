package filip.custom.data_structs.trees.binary.red_black.oper.insert;

import filip.custom.data_structs.trees.binary.red_black.RBTNode;
import filip.custom.data_structs.trees.operations.EntryInsertion;

/**
 * A class that represents an insertion to a <b>Red-Black Tree</b>.<br>
 * 
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in a tree.
 * @param <V> Type of values stored in a tree.
 */
public abstract class AbstractRBTInsertion<K extends Comparable<K>, V> implements EntryInsertion<K, V> {
	
	/**
	 * Root of the tree calling this insertion.
	 */
	protected RBTNode<K, V> root;
	
	/**
	 * Whether or not the last call to <code>insert</code> function actually
	 * inserted a new entry.
	 */
	protected boolean inserted;
	
	/**
	 * Creates a new instance of {@link AbstractRBTInsertion}.
	 * 
	 * @param root Root of the tree this insertion is being called upon.
	 */
	public AbstractRBTInsertion(RBTNode<K, V> root) {
		this.root = root;
		this.inserted = false;
	}

	@Override
	public boolean isInserted() {
		return inserted;
	}
}
