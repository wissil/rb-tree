package filip.custom.data_structs.trees.binary;

import filip.custom.data_structs.trees.nodes.SearchTreeNode;

public class BSTNode<K extends Comparable<? super K>, V> extends SearchTreeNode<K, V> {

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
}
