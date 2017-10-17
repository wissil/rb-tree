package filip.custom.data_structs.trees.traversal;

import filip.custom.data_structs.trees.SearchTree;
import filip.custom.data_structs.trees.traversal.visitors.SearchTreeNodeVisitor;

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
 * @param <T> Type of tree being traversed.
 */
public interface SearchTreeTraversal<K extends Comparable<? super K>, V, T extends SearchTree<K, V>> {

	/**
	 * Defines a traversal of a specific {@link SearchTree}.
	 * 
	 * @param tree Tree being traversed.
	 * @param visitor A visitor that implements action that should be taken on any
	 * node visited while traversing a given <code>tree</code>.
	 */
	void traverse(T tree, SearchTreeNodeVisitor<K, V> visitor);
}
