package filip.custom.data_structs.trees.nodes;

import java.util.Objects;

import filip.custom.data_structs.trees.SearchTree;

/**
 * A class that represents a node of a {@link SearchTree}.<br>
 * 
 * {@link CharSequence} interface is implemented to allow better manipulation of
 * textual representations of the objects of this class.
 * 
 * @author fiilip
 *
 * @param <K> Key stored in the node.<br> 
 * <code>null</code> values are not allowed.
 * @param <V> Value stored in the node.<br>
 * <code>null</code> values are allowed.
 */
public abstract class SearchTreeNode<K extends Comparable<? super K>, V> 
					implements Comparable<SearchTreeNode<K, V>>, CharSequence{
	
	/**
	 * Key stored in this node.
	 */
	private final K key;
	
	/**
	 * Value stored in this node.
	 */
	private final V value;
	
	/**
	 * Textual representation of this node.
	 */
	private final String textual;
	
	/**
	 * Creates a new instance of {@link SearchTreeNode}.
	 * 
	 * @param key Key stored in this node. <null> values not allowed.
	 * @param value Value stored in this node. <null> values allowed.
	 */
	public SearchTreeNode(K key, V value) {
		this.key = Objects.requireNonNull(key);
		this.value = value;
		this.textual = String.format("(K:%s, V:%s)", key, value);
	}

	/**
	 * Gets the key stored in this node.
	 * 
	 * @return key stored in this node.
	 */
	public K getKey() {
		return key;
	}
	
	/**
	 * Gets the value stored in this node.
	 * 
	 * @return value stored in this node.
	 */
	public V getValue() {
		return value;
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
	
	@Override
	public int compareTo(SearchTreeNode<K, V> node) {
		int compared = key.compareTo(node.key);
		
		if (compared < 0) return -1;
		if (compared > 0) return 1;
		
		return 0;
	}
	
	@Override
	public String toString() {
		return textual;
	}
}
