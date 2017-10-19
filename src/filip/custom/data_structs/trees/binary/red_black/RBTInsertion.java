package filip.custom.data_structs.trees.binary.red_black;

import filip.custom.data_structs.trees.algorithms.EntryInsertion;
import filip.custom.data_structs.trees.binary.red_black.RBTNode.Color;
import filip.custom.data_structs.trees.nodes.SearchTreeNode;

/**
 * A class that represents an insertion to a <b>Red-Black Tree</b>.<br>
 * 
 * The actual algorithm that performs the insertion is implemented here.<br>
 * 
 * The algorithm: <br>
 * perform binary insertion of a node<br>
 * 		* node being added is always colored red
 * 		* IF a node is a root node: paint the node black
 * 		* ELSE IF parent of a node is also a red node: 
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
		if (root == null) {
			// check if this is root
			root = new RBTNode<>(key, value, Color.BLACK, null);
			inserted = true;
		} else {		
			/* Perform binary insertion */
			RBTNode<K, V> newNode = binaryInsert(key, value);
			
			/* Re-balance the tree if needed */
			if (newNode != null && newNode.getParent().getColor().equals(Color.RED)) {
				
			}
		}
		
		return root;
	}

	/**
	 * Performs the binary insertion of an entry with the given <code>key</code>
	 * and the given <code>value</code>.
	 * 
	 * @param key Key of the entry being inserted to this tree.
	 * @param value Value of the entry being inserted to this tree.
	 * @return A reference to the newly inserted node, or <code>null</code> if nothing was inserted.
	 */
	private RBTNode<K, V> binaryInsert(K key, V value) {
		RBTNode<K, V> tmp = root;
		RBTNode<K, V> newNode = null;
		
		/* Perform binary insertion */
		while (true) {
			int compared = key.compareTo(tmp.getKey());
			
			if (compared < 0) {
				// go left
				if (tmp.getLeft() == null) {
					newNode = new RBTNode<>(key, value, Color.RED, tmp);
					tmp.setLeft(newNode);
					inserted = true; break;
				} else {
					tmp = (RBTNode<K, V>) tmp.getLeft();
				}			
			} else if (compared > 0) {
				// go right
				if (tmp.getRight() == null) {
					newNode = new RBTNode<>(key, value, Color.RED, tmp);
					tmp.setRight(newNode);
					inserted = true; break;
				} else {
					tmp = (RBTNode<K, V>) tmp.getRight();
				}
			} else {
				// already exists
				inserted = false; break;
			}
		}
		return newNode;
	}
	
	@Override
	public boolean isInserted() {
		return inserted;
	}

}
