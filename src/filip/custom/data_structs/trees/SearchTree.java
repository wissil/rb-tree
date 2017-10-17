package filip.custom.data_structs.trees;

import filip.custom.data_structs.trees.nodes.SearchTreeNode;

/**
 * Interface that represents any kind of a <b>Search Tree</b>.<br>
 * 
 * This type of data structure is often also called <b>Ordered Tree</b> 
 * or <b>Sorted Tree</b> as the elements in such data structures are stored in
 * a sorted manner to allow faster lookup, addition or removal of elements.<br>
 * 
 * Duplicates are not allowed.
 * 
 * @author fiilip
 * 
 * @param <K> {@link Comparable} parameter of this interface that represents the key 
 * objects that are stored in this <b>Search Tree</b>. For the purposes of a <b>Search Tree</b>,
 * it's keys need to be comparable to one another so that the algorithm is able to calculate the object's placement
 * in the data structure.
 *
 * @param <V> Parameter of this interface representing the value objects stored in this tree.
 */
public interface SearchTree<K extends Comparable<? super K>, V> {
	
	/**
	 * Inserts the given <code>key, value</code> pair to this {@link SearchTree}.
	 * 
	 * @param key Key to the provided <code>value</code>.
	 * @param value Value object.
	 * @throws IllegalArgumentException If the <code>key</code> is <code>null</code>.
	 * @return <code>true</code> if the insertion succeeded, and <code>false</code> otherwise.
	 * Insertion is not succeeded if and only if the element with the specified <code>key</code> is
	 * already in this tree.
	 */
	boolean insert(K key, V value) throws IllegalArgumentException;
	
	/**
	 * Removes the value for a given <code>key</code> from this {@link SearchTree}.
	 * 
	 * @param key Key being used for the value object.
	 * @return Value object for the given <code>key</code> if such exists, and <code>null</code> otherwise.
	 * @throws IllegalArgumentException If the <code>key</code> is <code>null</code>.
	 */
	V remove(K key) throws IllegalArgumentException;

	/**
	 * Informs whether or not this {@link SearchTree} contains the object for a given <code>key</code>.
	 * 
	 * @param key Key for the element of interest.
	 * @return <code>true</code> if the given object with a given <code>key</code> exists in this tree, and <code>false</code> otherwise.
	 * @throws IllegalArgumentException If the <code>key</code> is <code>null</code>.
	 */
	boolean contains(K key) throws IllegalArgumentException;
	
	/**
	 * Informs whether or not this {@link SearchTree} is empty.
	 * 
	 * @return <code>true</code> if this tree contains no elements, <code>false</code> otherwise.
	 */
	boolean isEmpty();
	
	/**
	 * Clears this {@link SearchTree} from all the elements.<br>
	 * After this method is called, no elements is stored in the tree.
	 */
	void clear();
	
	/**
	 * Gets all the elements with a key greater than the given key <code>toCompare</code>.
	 * 
	 * @param toCompare The key being compared to. This method returns a new {@link SearchTree}
	 * containing all the elements with a key greater than this key.
	 * @return new instance of {@link SearchTree} containing only the elements with key greater than <code>toCompare</code>.
	 * If no such elements are found in the tree, an empty {@link SearchTree} is returned.
	 */
	SearchTree<K, V> getGreaterThan(K toCompare);
	
	/**
	 * Gets all the elements with a key less than the given key <code>toCompare</code>.
	 * 
	 * @param toCompare The key being compared to. This method returns all the elements with a key less than this key.
	 * @return new instance of {@link SearchTree} containing only the elements with key less than <code>toCompare</code>.
	 * If no such elements are found in the tree, an empty {@link SearchTree} is returned.
	 */
	SearchTree<K, V> getLessThan(K toCompare);
	
	/**
	 * Gets all the elements with the key greater than or equal to the <code>start</code> key, and 
	 * less than or equal to the <code>end</code> key.
	 * 
	 * @param fromKey Start of the interval.
	 * @param toKey End of the interval.
	 * @return {@link SearchTree} of elements with the key greater than or equal to <code>fromKey</code> and
	 * less than or equal to <code>toKey</code>. If no such elements exist, empty {@link SearchTree} is returned.
	 */
	SearchTree<K, V> getInterval(K fromKey, K toKey);
	
	/**
	 * Gets the root node of this tree.
	 * 
	 * @return Root of this tree.
	 */
	SearchTreeNode<K, V> getRoot();
}
