package filip.custom.data_structs.trees.binary;

import filip.custom.data_structs.trees.nodes.SearchTreeNode;

/**
 * A class that represents a node of a <b>Binary Search Tree</b>.
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in nodes.
 * @param <V> Type of values stored in nodes.
 */
public class BSTNode<K extends Comparable<K>, V> extends SearchTreeNode<K, V> {

	/**
	 * Node that is left to this node.<br>
	 * Left node is by the definition greater than <code>this</code>.
	 */
	BSTNode<K, V> left = null;
	
	/**
	 * Node that is right to this node.<br>
	 * Right node is by the definition less than <code>this</code>.
	 */
	BSTNode<K, V> right = null;
	
	/**
	 * Creates a new instance of {@link BSTNode}.
	 * 
	 * @param key Key stored in this node.
	 * @param value Value stored in this node.
	 */
	public BSTNode(K key, V value) {
		super(key, value);
	}

	/**
	 * Gets the root of left subtree of this node.
	 * 
	 * @return Left node.
	 */
	public BSTNode<K, V> getLeft() {
		return left;
	}

	/**
	 * Sets the root of left subtree of this node.
	 * 
	 * @param left Left node.
	 */
	public void setLeft(BSTNode<K, V> left) {
		this.left = left;
	}

	/**
	 * Gets the root of the right subtree of this node.
	 * 
	 * @return Right node.
	 */
	public BSTNode<K, V> getRight() {
		return right;
	}

	/**
	 * Sets the root of the right subtree of this node.
	 * 
	 * @param right Right node.
	 */
	public void setRight(BSTNode<K, V> right) {
		this.right = right;
	}
}
