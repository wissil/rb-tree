package filip.custom.data_structs.trees.binary;


import java.util.Iterator;

import filip.custom.data_structs.trees.SearchTree;
import filip.custom.data_structs.trees.binary.iterators.BSTIterator;
import filip.custom.data_structs.trees.binary.traversal.InOrderBSTreeTraversal;
import filip.custom.data_structs.trees.traversal.visitors.CollectTreeVisitor;
import filip.custom.data_structs.trees.traversal.visitors.FilterTreeVisitor;

/**
 * This class represents any <b>Binary Search Tree</b>.<br>
 * 
 * It is a special case of the {@link SearchTree} in which any parent node has
 * exactly two children nodes.
 * 
 * @author fiilip
 *
 * @param <K> {@link Comparable} parameter of this interface that represents the key 
 * objects that are stored in this <b>Search Tree</b>. For the purposes of a <b>Search Tree</b>,
 * it's keys need to be comparable to one another so that the algorithm is able to calculate the object's placement
 * in the data structure.
 *
 * @param <V> Parameter of this interface representing the value objects stored in this binary tree.
 */
public class BinarySearchTree<K extends Comparable<K>, V> implements SearchTree<K, V>  {

	/**
	 * A root node of this <b>Binary Search Tree</b>.
	 */
	private BSTNode<K, V> root = null;
	
	/**
	 * Default constructor.
	 */
	public BinarySearchTree() {
	}
		
	
	/**
	 * Checks if the given <code>key</code> is <code>null</code>.<br>
	 * If the given <code>key</code> is <code>null</code>, then this method throws an
	 * {@link IllegalArgumentException}, otherwise nothing is returned.
	 * 
	 * @param key Object of interest.
	 */
	private void nullCheckKey(K key) throws IllegalArgumentException {
		if (key == null) {
			throw new IllegalArgumentException("Key should not be null.");
		}
	}
	
	@Override
	public boolean contains(K key) throws IllegalArgumentException {
		nullCheckKey(key);
		
		// check if root exists
		if (root == null) {
			return false;
		}
		
		// at this point, root exists
		BSTNode<K, V> tmp = root;
		
		while (tmp != null) {
			// make a comparison
			int compared = tmp.getKey().compareTo(key);
					
			if (compared < 0) {
				// result is right
				tmp = tmp.right;
			} else if (compared > 0) {
				// result is left
				tmp = tmp.left;
			} else {
				// search hit
				return true;
			}
		}
		
		// not found
		return false;
	}
	
	@Override
	public boolean isEmpty() {
		return root == null;
	}	

	@Override
	public boolean insert(K key, V value) throws IllegalArgumentException {
		nullCheckKey(key);
		
		// 1) create a node to insert
		BSTNode<K, V> toInsert = new BSTNode<>(key, value);
		
		// 2) find a place to insert it
		if (root == null) {
			root = toInsert;
		}
		
		BSTNode<K, V> tmp = root;
		
		while (true) {
			int compared = key.compareTo(tmp.getKey());
			
			if (compared < 0) {
				// go left
				if (tmp.left == null) {
					tmp.left = toInsert;
					return true;
				} else {
					tmp = tmp.left;
				}
			} else if (compared > 0) {
				// go right
				if (tmp.right == null) {
					tmp.right = toInsert;
					return true;
				} else {
					tmp = tmp.right;
				}
			} else {
				// already exists
				return false;
			}
		}
	}

	@Override
	public V remove(K key) throws IllegalArgumentException {
		nullCheckKey(key);
		
		/* 1) Find the node to be deleted and it's parent */
		BSTNode<K, V> parent = null;
		BSTNode<K, V> toDelete = root;
		
		// if the node to be deleted is left child of it's parent
		boolean isLeft = false;
		
		while (true) {
			// searched object not found if
			if (toDelete == null) return null;
			
			int compared = key.compareTo(toDelete.getKey());
			
			if (compared > 0) {
				// go right
				isLeft = false;
				parent = toDelete;
				toDelete = toDelete.getRight();
			} else if (compared < 0) {
				// go left
				isLeft = true;
				parent = toDelete;
				toDelete = toDelete.getLeft();
			} else {
				// object found
				break;
			}
		}
		/* At this point, the node to delete and it's parent are found */
		V value = toDelete.getValue();
		
		/*
		 * Three possible scenarios:
		 * 1) toDelete is a leaf node, ie. has no children
		 * 2) toDelete has only one child
		 * 3) toDelete has two children
		 */
		int children = getNumberOfChildren(toDelete);
						
		if (children == 0) {			
			// 1) leaf node			
			if (parent == null) {
				// root is being deleted
				root = null;
			} else if (parent.getLeft().getKey().equals(key)) {
				// left child is being deleted
				parent.setLeft(null);
			} else {
				// right child is being deleted
				parent.setRight(null);
			}
			
		} else if (children == 1) {			
			// 2) one child node	
			BSTNode<K, V> child = null;
			
			if (toDelete.getLeft() != null) {
				// has left subtree
				child = toDelete.getLeft();
			} else {
				// has right subtree
				child = toDelete.getRight();
			}
			
			if (parent == null) {
				// root is being deleted
				root = child;
			} else {
				// not root is being deleted
				if (isLeft) {
					parent.setLeft(child);
				} else {
					parent.setRight(child);
				}
			}
			
		} else if (children == 2) {
			// 3) TODO two child nodes
			System.err.println("Not implemented for 2 child nodes!");
			
		} else {
			throw new IllegalArgumentException("Can't delete a node with an illegal number of child nodes.");
		}
		
		return value;
	}

	@Override
	public void clear() {
		root = null;
	}


	@Override
	public SearchTree<K, V> getLessThan(K high) {		
		return getInterval(null, high);
	}

	@Override
	public SearchTree<K, V> getGreaterThan(K low) {		
		return getInterval(low, null);
	}

	@Override
	public SearchTree<K, V> getInterval(K low, K high) {
		FilterTreeVisitor<K, V> v = new FilterTreeVisitor<>(low, high, this.getClass());	
		new InOrderBSTreeTraversal<>(root, v).traverse();			
		return v.getFiltered();
	}

	@Override
	public String toString() {
		CollectTreeVisitor<K, V> v = new CollectTreeVisitor<>();
		new InOrderBSTreeTraversal<>(root, v).traverse();
		return String.join(System.lineSeparator(), v.getNodes());	
	}
	
	/**
	 * Gets the number of child nodes for a given <code>node</code>.
	 * 
	 * @param node Node of interest.
	 * @return Number of child nodes for a given <code>node</code>.
	 */
	private int getNumberOfChildren(BSTNode<K, V> node) {
		if (node == null) {
			throw new IllegalArgumentException("Can't get a number of child nodes for null.");
		}
		
		int children = 0;
		
		if (node.getLeft() != null) children ++;
		if (node.getRight() != null) children ++;
		
		return children;
	}

	@Override
	public Iterator<Entry<K, V>> iterator() {
		return new BSTIterator<>(root);
	}
}
