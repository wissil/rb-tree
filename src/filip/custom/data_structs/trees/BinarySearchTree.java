package filip.custom.data_structs.trees;

import java.util.Map;

/**
 * Interface that represents any kind of a <b>Binary Search Tree</b>.<br>
 * 
 * This type of data structure is often also called <b>Ordered Binary Tree</b> 
 * or <b>Sorted Binary Tree</b> as the elements in such data structures are stored in
 * a sorted manner to allow faster lookup, addition or removal of elements.
 * 
 * @author fiilip
 * 
 * @param <K> {@link Comparable} parameter of this interface that represents the key 
 * objects that are stored in this <b>Binary Search Tree</b>. For the purposes of a <b>Binary Search Tree</b>,
 * it's keys need to be comparable to one another so that the algorithm is able to calculate the object's placement
 * in the data structure.
 *
 * @param <V> Parameter of this interface representing the value objects stored in this tree.
 */
public interface BinarySearchTree<K extends Comparable<? super K>, V> {
	
	/**
	 * Inserts the given <code>key, value</code> pair to this {@link BinarySearchTree}.
	 * 
	 * @param key Key to the provided <code>value</code>.
	 * @param value Value object.
	 */
	void insert(K key, V value);
	
	/**
	 * Removes the value for a given <code>key</code> from this {@link BinarySearchTree}.
	 * 
	 * @param key Key being used for the value object.
	 * @return Value object for the given <code>key</code> if such exists, and <code>null</code> otherwise.
	 */
	V remove(K key);

	/**
	 * Informs whether or not this {@link BinarySearchTree} contains the object for a given <code>key</code>.
	 * 
	 * @param key Key for the element of interest.
	 * @return <code>true</code> if the given object with a given <code>key</code> exists in this tree, and <code>false</code> otherwise.
	 */
	boolean contains(K key);
	
	/**
	 * Informs whether or not this {@link BinarySearchTree} is empty.
	 * 
	 * @return <code>true</code> if this tree contains no elements, <code>false</code> otherwise.
	 */
	boolean isEmpty();
	
	/**
	 * Gets all the elements with a key greater than the given key <code>toCompare</code>.
	 * 
	 * @param toCompare The key being compared to. This method returns all the elements with a key greater than this key.
	 * @return {@link Map} of <code>Key, Value</code> pairs greater than the <code>toCompare</code> key.
	 * If no such elements are found in the tree, an empty map is returned.
	 */
	Map<K, V> getGreaterThan(K toCompare);
	
	/**
	 * Gets all the elements with a key less than the given key <code>toCompare</code>.
	 * 
	 * @param toCompare The key being compared to. This method returns all the elements with a key less than this key.
	 * @return {@link Map} of <code>Key, Value</code> pairs less than the <code>toCompare</code> key.
	 * If no such elements are found in the tree, an empty map is returned.
	 */
	Map<K, V> getLessThan(K toCompare);
	
	/**
	 * Gets all the elements with the key greater than or equal to the <code>start</code> key, and 
	 * less than or equal to the <code>end</code> key.
	 * 
	 * @param start Start of the interval.
	 * @param end End of the interval.
	 * @return {@link Map} of elements with the key greater than or equal to <code>start</code> and
	 * less than or equal to <code>end</code>. If no such elements exist, empty map is returned.
	 */
	Map<K, V> getInterval(K start, K end);
}
