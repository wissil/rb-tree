package filip.custom.data_structs.trees.binary.red_black.oper.insert;

import filip.custom.data_structs.trees.binary.red_black.RBTNode;
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
public class RBTInsertion<K extends Comparable<K>, V> extends AbstractRBTInsertion<K, V> {
	
	/**
	 * Creates a new instance of {@link RBTInsertion}.
	 * 
	 * @param root Root of the tree calling this insertion.
	 */
	public RBTInsertion(RBTNode<K, V> root) {
		super(root);
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
			if (treeNeedsRebalance(newNode)) {
				rebalance(newNode);
			}
		}
		
		return root;
	}
	
	/**
	 * Performs the re-balancing of the tree after the insertion of
	 * a new node, <code>n</code>.
	 * 
	 * @param n New node that was added to this tree.
	 */
	private void rebalance(RBTNode<K, V> n) {
		/*
		 * Guaranteed to have a parent.
		 * Guaranteed to have a grandparent.
		 * Guaranteed to have an uncle that might be null, which means it's black.
		 */
		while (isRed(parent(n))) {
			RBTNode<K, V> u = null; // uncle

			if (isLeftChild(parent(n), grandparent(n))) {
				u = (RBTNode<K, V>) grandparent(n).getRight();

				if (isRed(u)) {
					parent(n).setColor(Color.BLACK);
					u.setColor(Color.BLACK);
					grandparent(n).setColor(Color.RED);
					n = grandparent(n);
					continue;
				} 

				if (isRightChild(n, parent(n))) {
					// double rotation needed
					n = parent(n);
					leftRotate(n);
				}
				
				parent(n).setColor(Color.BLACK);
				grandparent(n).setColor(Color.RED);
				rightRotate(grandparent(n));				
			} else {
				u = (RBTNode<K, V>) grandparent(n).getLeft();

				if (isRed(u)) {
					parent(n).setColor(Color.BLACK);
					u.setColor(Color.BLACK);
					grandparent(n).setColor(Color.RED);
					n = grandparent(n);
					continue;
				}

				if (isLeftChild(n, parent(n))) {
					// double rotation needed
					n = parent(n);
					rightRotate(n);
				}
				
				parent(n).setColor(Color.BLACK);
				grandparent(n).setColor(Color.RED);
				leftRotate(grandparent(n));
			}
		}
		root.setColor(Color.BLACK);
	}
	
	
	/**
	 * Checks whether or not this tree needs to be re-balanced after the addition
	 * of a new node, <code>addedNode</code>.
	 * 
	 * @param addedNode Last node added to the tree.
	 * @return <code>true</code> if tree needs to be re-balanced, and <code>false</code> otherwise.
	 */
	private boolean treeNeedsRebalance(RBTNode<K, V> addedNode) {
		return addedNode != null && addedNode.getParent().getColor().equals(Color.RED);
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
					newNode.setParent(tmp);
					inserted = true; break;
				} else {
					tmp = (RBTNode<K, V>) tmp.getLeft();
				}			
			} else if (compared > 0) {
				// go right
				if (tmp.getRight() == null) {
					newNode = new RBTNode<>(key, value, Color.RED, tmp);
					tmp.setRight(newNode);
					newNode.setParent(tmp);
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

}
