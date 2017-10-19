package filip.custom.data_structs.trees.binary.red_black;

import filip.custom.data_structs.trees.algorithms.EntryInsertion;
import filip.custom.data_structs.trees.nodes.SearchTreeNode;

/**
 * A class that represents an insertion to a <b>Red-Black Tree</b>.<br>
 * 
 * The actual algorithm that performs the insertion is implemented here.
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in a tree.
 * @param <V> Type of values stored in a tree.
 */
public class RBTInsertion<K extends Comparable<K>, V> implements EntryInsertion<K, V> {
	
	/**
	 * Root of the tree calling this insertion.
	 */
	private RBTNode<K, V> root;
	
	/**
	 * Whether or not the last call to <code>insert</code> function actually
	 * inserted a new entry.
	 */
	private boolean inserted;
	
	/**
	 * Creates a new instance of {@link RBTInsertion}.
	 * 
	 * @param root Root of the tree calling this insertion.
	 */
	public RBTInsertion(RBTNode<K, V> root) {
		this.root = root;
		this.inserted = false;
	}

	@Override
	public SearchTreeNode<K, V> insert(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInserted() {
		return inserted;
	}

}
