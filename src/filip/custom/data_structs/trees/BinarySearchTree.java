package filip.custom.data_structs.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
public class BinarySearchTree<K extends Comparable<? super K>, V> implements SearchTree<K, V>  {

	/**
	 * A class that represents a node of a <b>Binary Search Tree</b>.<br>
	 * 
	 * {@link CharSequence} interface is implemented to allow better manipulation of
	 * textual representations of the objects of this class.
	 * 
	 * @author fiilip
	 *
	 * @param <K> Key
	 * @param <V> Value
	 */
	private static class Node<K extends Comparable<? super K>, V> implements Comparable<Node<K, V>>, CharSequence {
		
		/**
		 * Key object.
		 */
		private final K key;
		
		/**
		 * Value object.
		 */
		private final V value;
		
		/**
		 * Node that is left to this node.<br>
		 * This node is by the definition greater than this node.
		 */
		private Node<K, V> left = null;
		
		/**
		 * Node that is right to this node.<br>
		 * This node is by the definition less than this node.
		 */
		private Node<K, V> right = null;
		
		/**
		 * Textual representation of this node.
		 */
		private final String textual;
		
		/**
		 * Creates a new instance of a {@link Node}.
		 * 
		 * @param key Key of this node.
		 * @param value Value of this node.
		 */
		protected Node(K key, V value) {
			this.key = Objects.requireNonNull(key);
			this.value = value;
			this.textual = String.format("(%s, %s)", key.toString(), value.toString());
		}

		@Override
		public int compareTo(Node<K, V> node) {
			int compared = key.compareTo(node.key);
			
			if (compared < 0) return -1;
			if (compared > 0) return 1;
			
			return 0;
		}
		
		/**
		 * Gets the key stored in this node.
		 * 
		 * @return Key of this node.
		 */
		protected K getKey() {
			return key;
		}
		
		/**
		 * Gets the value stored in this node.
		 * 
		 * @return Value of this node.
		 */
		protected V getValue() {
			return value;
		}
		
		@Override
		public String toString() {
			return textual;
		}

		@Override
		public int length() {
			return textual.length();
		}

		@Override
		public char charAt(int index) {
			return textual.charAt(index);
		}

		@Override
		public CharSequence subSequence(int start, int end) {
			return textual.subSequence(start, end);
		}
	}

	/**
	 * A root node of this <b>Binary Search Tree</b>.
	 */
	private Node<K, V> root = null;
	
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
	private void nullCheck(K key) throws IllegalArgumentException {
		if (key == null) {
			throw new IllegalArgumentException("Key should not be null.");
		}
	}
	
	
	@Override
	public boolean contains(K key) throws IllegalArgumentException {
		nullCheck(key);
		
		// check if root exists
		if (root == null) {
			return false;
		}
		
		// at this point, root exists
		Node<K, V> tmp = root;
		
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
	public SearchTree<K, V> getGreaterThan(K toCompare) throws IllegalArgumentException {
		nullCheck(toCompare);
		
		return isEmpty() ? 
				new BinarySearchTree<>() : 
				traverseAndAdd(toCompare, new BinarySearchTree<>(), true);
	}

	private BinarySearchTree<K, V> traverseAndAdd(K toCompare, BinarySearchTree<K, V> subTree, boolean greater) {
		traverseAndAdd(root, toCompare, subTree, greater);
		
		return subTree;
	}
	
	private void traverseAndAdd(Node<K, V> cRoot, K toCompare, BinarySearchTree<K, V> subTree, boolean greater) {
		// do work
		if (cRoot == null) return;
		
		int compared = cRoot.getKey().compareTo(toCompare);
		
		if ((greater && compared > 0) || (!greater && compared < 0)) {
			subTree.insert(cRoot.getKey(), cRoot.getValue());
		}
		
		if (cRoot.left != null) {
			// go left
			traverseAndAdd(cRoot.left, toCompare, subTree, greater);
		}
		
		if (cRoot.right != null) {
			// go right
			traverseAndAdd(cRoot.right, toCompare, subTree, greater);
		}
	}

	@Override
	public boolean insert(K key, V value) throws IllegalArgumentException {
		nullCheck(key);
		
		// 1) create a node to insert
		Node<K, V> toInsert = new Node<>(key, value);
		
		// 2) find a place to insert it
		if (root == null) {
			root = toInsert;
		}
		
		Node<K, V> tmp = root;
		
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
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void clear() {
		root = null;
	}


	@Override
	public SearchTree<K, V> getLessThan(K toCompare) throws IllegalArgumentException {
		nullCheck(toCompare);
		
		return isEmpty() ? 
				new BinarySearchTree<>() : 
				traverseAndAdd(toCompare, new BinarySearchTree<>(), false);
	}


	@Override
	public SearchTree<K, V> getInterval(K fromKey, K toKey) throws IllegalArgumentException {
		nullCheck(fromKey);
		nullCheck(toKey);
		
		return isEmpty() ?
				new BinarySearchTree<>() :
				traverseAndAdd(fromKey, toKey, new BinarySearchTree<>());
	}
	
	private BinarySearchTree<K, V> traverseAndAdd(K fromKey, K toKey, BinarySearchTree<K, V> subTree) {
		traverseAndAdd(root, fromKey, toKey, subTree);
		
		return subTree;
	}
	
	private void traverseAndAdd(Node<K, V> cRoot, K fromKey, K toKey, BinarySearchTree<K, V> subTree) {
		// do work
		if (cRoot == null) return;

		int comparedFrom = cRoot.getKey().compareTo(fromKey);
		int comparedTo = cRoot.getKey().compareTo(toKey);
		
		if (comparedFrom > 0 && comparedTo < 0) {
			subTree.insert(cRoot.getKey(), cRoot.getValue());
		}

		if (cRoot.left != null) {
			// go left
			traverseAndAdd(cRoot.left, fromKey, toKey, subTree);
		}

		if (cRoot.right != null) {
			// go right
			traverseAndAdd(cRoot.right, fromKey, toKey, subTree);
		}
	}


	@Override
	public String inOrderTraversal() {	
		List<Node<K, V>> nodes = new ArrayList<>();
		
		if (!isEmpty()) {
			addNodesToList(nodes, root);
		}
			
		return String.join(System.lineSeparator(), nodes);
		
	}
	
	@Override
	public String toString() {
		return inOrderTraversal();
	}
	

	/**
	 * Adds all the nodes from this {@link BinarySearchTree} to the <code>nodes</code> list.
	 * 
	 * @param nodes List of nodes being populated by the call of this method.
	 * @param cRoot Current root of the subtree.
	 */
	private void addNodesToList(List<Node<K, V>> nodes, Node<K, V> cRoot) {
		// go to the left sub-tree
		if (cRoot.left != null) {
			addNodesToList(nodes, cRoot.left);
		}
				
		// process
		nodes.add(cRoot);
		
		// go to the right sub-tree
		if (cRoot.right != null) {
			addNodesToList(nodes, cRoot.right);
		}
	}
}
