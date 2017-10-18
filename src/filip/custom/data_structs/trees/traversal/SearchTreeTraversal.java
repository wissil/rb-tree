package filip.custom.data_structs.trees.traversal;

import filip.custom.data_structs.trees.SearchTree;

/**
 * An interface that represents a traversal of any {@link SearchTree}.<br>
 * 
 * This is an interface consisted of only method, <code>traverse(SearchTree<K, V> tree)</code>,
 * which defines the action of traversal of all the nodes in a tree..
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in a {@link SearchTree}.
 * @param <V> Type of values stored in a {@link SearchTree}.
 */
public interface SearchTreeTraversal<K extends Comparable<K>, V> {

	/**
	 * Defines a traversal of a specific {@link SearchTree}.
	 */
	void traverse();
}
