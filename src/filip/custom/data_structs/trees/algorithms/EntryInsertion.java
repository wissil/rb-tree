package filip.custom.data_structs.trees.algorithms;

import filip.custom.data_structs.trees.nodes.SearchTreeNode;

/**
 * An interface that represents the insertion of an entry to any kind of
 * a <b>Search Tree</b>.
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in a tree.
 * @param <V> Type of values stored in a tree.
 */
public interface EntryInsertion<K extends Comparable<K>, V> {
		
	/**
	 * Performs the insertion of an entry with the <code>key</code> and
	 * the given <code>value</code> to a <b>Search Tree</b>.
	 * 
	 * @param key Key of an entry being inserted to a tree.
	 * @param value Value of an entry being inserted to a tree.
	 * @return Reference to a root node of the tree this insertion was called upon.
	 */
	SearchTreeNode<K, V> insert(K key, V value);

	/**
	 * Method that checks whether or not the last call to {@link #insert(K, V)}
	 * inserted a new entry to the tree or not.
	 * 
	 * @return <code>true</code> if the last call to {@link #insert(K, V)} inserted
	 * a new value to the tree, and <code>false</code> otherwise.
	 */
	boolean isInserted();
}
