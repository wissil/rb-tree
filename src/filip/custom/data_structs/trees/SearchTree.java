package filip.custom.data_structs.trees;

import java.util.Map;

import filip.custom.data_structs.trees.factories.TreeFactory;

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
public interface SearchTree<K extends Comparable<K>, V> extends Iterable<SearchTree.Entry<K, V>> {
	
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
	 * Gets all the elements with the key greater than to the <code>start</code> key, and 
	 * less than the <code>end</code> key.
	 * 
	 * @param fromKey Start of the interval.
	 * @param toKey End of the interval.
	 * @return {@link SearchTree} of elements with the key greater than or equal to <code>fromKey</code> and
	 * less than or equal to <code>toKey</code>. If no such elements exist, empty {@link SearchTree} is returned.
	 */
	SearchTree<K, V> getInterval(K fromKey, K toKey);
	
	/**
	 * Gets the number of elements of this tree.
	 * 
	 * @return Number of elements stored in this tree.
	 */
	int size();
	
	/**
	 * Gets the value for a given <code>key</code>.
	 * 
	 * @param key Key the value is being obtained for.
	 * @return Value obtained for a given <code>key</code>. If no value for a given <code>key</code>
	 * is found, then <code>null</code> is returned.
	 * @throws IllegalArgumentException If the <code>key</code> is <code>null</code>.
	 */
	V get(K key) throws IllegalArgumentException;
	
	/**
	 * Gets the depth of this tree, ie. number of levels.
	 * 
	 * @return Depth of this tree.
	 */
	int depth();
	
	/**
	 * Statically creates a new instance of a {@link SearchTree} populated with the given <code>entries</code>.<br>
	 * The concrete type of a returned tree will depend on a given {@link TreeFactory}.
	 * 
	 * @param entries Map of entries the tree is populated from.
	 * @param factory Factory of a concrete tree.
	 * @return New concrete instance of a {@link SearchTree} based on the given <code>entries</code>
	 * and a given <code>factory</code>.
	 */
	static <K extends Comparable<K>, V> SearchTree<K, V> createFromMap(Map<K, V> entries, TreeFactory<K, V> factory) {
		return factory.createFromMap(entries);
	}
	
	/**
	 * Inner class that represents an entry of this {@link SearchTree}.<br>
	 * Entry is consisted of a <code>Key, Value</code> pair.
	 * 
	 * @author fiilip
	 *
	 * @param <K> Type of keys stored in an entry.
	 * @param <V> Type of values stored in an entry.
	 */
	static interface Entry<K, V> {
		
		/**
		 * Gets the key stored in this entry.
		 * 
		 * @return Key stored in this entry.
		 */
		K getKey();
		
		/**
		 * Gets the value stored in this entry.
		 * 
		 * @return Value stored in this entry.
		 */
		V getValue();
		
		/**
		 * Sets the <code>value</code> of this entry.
		 * 
		 * @param value Value being set to this entry.
		 */
		void setValue(V value);
	}
	
}
