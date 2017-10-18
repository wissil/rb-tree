package filip.custom.data_structs.trees.traversal.visitors;

import filip.custom.data_structs.trees.nodes.SearchTreeNode;

/**
 * A class that represents an action of printing the nodes for a tree
 * defined by the given {@link SearchTreeNode} root.
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in a tree.
 * @param <V> Type of values stored in a tree.
 */
public class PrintTreeVisitor<K extends Comparable<K>, V> implements SearchTreeNodeVisitor<K, V> {

	@Override
	public void processNode(SearchTreeNode<K, V> node) {
		System.out.println(node);
	}

}
