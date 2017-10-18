package filip.custom.data_structs.trees.traversal.visitors;

import filip.custom.data_structs.trees.nodes.SearchTreeNode;

/**
 * The interface that represents an action that is taken whenever a 
 * {@link SearchTreeNode} is visited.<br>
 * 
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in nodes being visited.
 * @param <V> Type of values stored in nodes being visited.
 */
public interface SearchTreeNodeVisitor<K extends Comparable<K>, V> {

	/**
	 * The action taken whenever a given <code>node</code> is visited.
	 * 
	 * @param node Node being visited.
	 */
	void processNode(SearchTreeNode<K, V> node);
}
