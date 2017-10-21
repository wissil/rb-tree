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
	 * Gets the parent node of a given <code>node</code>.
	 * 
	 * @param node Node of interest.
	 * @return Parent of a given <code>node</code>.
	 */
	private RBTNode<K, V> parent(RBTNode<K, V> node) {
		return node.getParent();
	}
	
	/**
	 * Gets the grandparent node of a given <code>node</code>.
	 * 
	 * @param node Node of interest.
	 * @return Grandparent of a given <code>node</code>.
	 */
	private RBTNode<K, V> grandparent(RBTNode<K, V> node) {
		return node.getParent().getParent();
	}
	
	/**
	 * Performs a right rotation about a given node <code>n</code>.
	 * 
	 * @param n Node about which the right rotation is called.
	 */
	private void rightRotate(RBTNode<K, V> n) {
        if (parent(n) != null) {
        	
        		if (isLeftChild(n, parent(n))) {
        			parent(n).setLeft(n.getLeft());
        		} else {
        			parent(n).setRight(n.getLeft());
        		}
        		
        		((RBTNode<K, V>) n.getLeft()).setParent(parent(n));
        		n.setParent((RBTNode<K, V>) n.getLeft());

        		if (n.getLeft().getRight() != null) {
        			((RBTNode<K, V>) n.getLeft().getRight()).setParent(n);
        		}
        		
        		n.setLeft(n.getLeft().getRight());
        		n.getParent().setRight(n);

        } else {
        		// need to rotate root
        		RBTNode<K, V> left = (RBTNode<K, V>) root.getLeft();
        		root.setLeft(root.getLeft().getRight());
        		((RBTNode<K, V>) left.getRight()).setParent(root);
        		root.setParent(left);

        		left.setRight(root);
        		left.setParent(null);
        		
        		root = left;
        }
    }
	
	/**
	 * Performs a left rotation about a given node <code>n</code>.
	 * 
	 * @param n Node about which the left rotation is called.
	 */
	private void leftRotate(RBTNode<K, V> n) {
        if (parent(n) != null) {
        	
            if (isLeftChild(n, parent(n))) {
            		parent(n).setLeft(n.getRight());
            } else {
            		parent(n).setRight(n.getRight());
            }
            
            ((RBTNode<K, V>) n.getRight()).setParent(n.getParent());
            n.setParent((RBTNode<K, V>) n.getRight());
            
            if (n.getRight().getLeft() != null) {
            		((RBTNode<K, V>) n.getRight().getLeft()).setParent(n);
            }
            
            n.setRight(n.getRight().getLeft());
            parent(n).setLeft(n);
            
        } else {
        		// need to rotate root
            RBTNode<K, V> right = (RBTNode<K, V>) root.getRight();
            root.setRight(right.getLeft());
            ((RBTNode<K, V>) right.getLeft()).setParent(root);
            root.setParent(right);
            
            right.setLeft(root);
            right.setParent(null);
            
            root = right;
        }
    }

	/**
	 * Checks whether the given <code>child</code> is a left child
	 * of a given <code>parent</code>.
	 * 
	 * @param child Child node.
	 * @param parent Parent node.
	 * @return <code>true</code> if the <code>child</code> is a left child, and <code>false</code> otherwise.
	 * @throws IllegalArgumentException If a provided <code>child</code> node doesn't have
	 * provided <code>parent</code> node as it's parent or any of the given nodes are <code>null</code>.
	 */
	private boolean isLeftChild(RBTNode<K, V> child, RBTNode<K, V> parent) {
		if (child == null) {
			throw new IllegalArgumentException("Provided child node is null");
		}
		
		if (parent == null) {
			throw new IllegalArgumentException("Provided parent node is null");
		}
		
		if (!child.getParent().equals(parent)) {
			throw new IllegalArgumentException("Provided parent node is not a parent to a provided child node");
		}
		return child.equals(parent.getLeft());
	}
	
	/**
	 * Checks whether the given <code>child</code> is a right child
	 * of a given <code>parent</code>.
	 * 
	 * @param child Child node.
	 * @param parent Parent node.
	 * @return <code>true</code> if the <code>child</code> is a left child, and <code>false</code> otherwise.
	 * @throws IllegalArgumentException If a provided <code>child</code> node doesn't have
	 * provided <code>parent</code> node as it's parent or any of the given nodes are <code>null</code>.
	 */
	private boolean isRightChild(RBTNode<K, V> child, RBTNode<K, V> parent) {
		return !isLeftChild(child, parent);
	}
	
	/**
	 * Checks whether a given node <code>n</code> is black.<br>
	 * If a node is not black, it is red.<br>
	 * 
	 * <code>null</code> nodes are considered black.
	 * 
	 * @param n Node of interest.
	 * @return <code>true</code> if <code>n</code> is black, and <code>false</code> if it is red.
	 */
	private boolean isBlack(RBTNode<K, V> n) {
		return n == null || n.getColor().equals(Color.BLACK);
	}
	
	/**
	 * Checks whether a given node <code>n</code> is red.<br>
	 * If a node is not red, it is black.<br>
	 * 
	 * <code>null</code> nodes are considered black.
	 * 
	 * @param n Node of interest.
	 * @return <code>true</code> if <code>n</code> is red, and <code>false</code> if it is black.
	 */
	private boolean isRed(RBTNode<K, V> n) {
		return !isBlack(n);
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
