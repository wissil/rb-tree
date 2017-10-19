package filip.custom.data_structs.trees.algorithms;

import filip.custom.data_structs.trees.nodes.SearchTreeNode;

/**
 * An interface that represents the removal of an entry from any kind of
 * a <b>Search Tree</b>.
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in a tree.
 * @param <V> Type of values stored in a tree.
 */
public interface EntryRemoval<K extends Comparable<K>, V> {

	/**
	 * Performs the removal of an entry with the <code>key</code> and
	 * from a <b>Search Tree</b>.
	 * 
	 * @param key Key of an entry being removed from a tree.
	 * @return Reference to a root node of the tree this insertion was called upon.
	 */
	SearchTreeNode<K, V> remove(K key);
	
	/**
	 * Gets the element that was removed from a tree by the last call to
	 * method {@link #remove(K)}.
	 * 
	 * @return The element that was removed by the last call to method
	 * {@link #remove(K)}, and <code>null</code> if last call removed nothing.
	 */
	V getValueRemoved();
}
