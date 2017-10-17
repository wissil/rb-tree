package filip.custom.data_structs.trees.binary.traversal;

import filip.custom.data_structs.trees.binary.BSTNode;
import filip.custom.data_structs.trees.binary.BinarySearchTree;
import filip.custom.data_structs.trees.traversal.visitors.SearchTreeNodeVisitor;

/**
 * A class that represents an in-order traversal of a {@link BinarySearchTree}.<br>
 * 
 * This type of traversal visits the node in their ascending order (ordered by the keys).
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in {@link BSTNode} objects.
 * @param <V> Type of values stored in {@link BSTNode} objects.
 */
public class InOrderBSTreeTraversal<K extends Comparable<? super K>, V> implements BSTreeTraversal<K, V> {

	
	@Override
	public void traverse(BinarySearchTree<K, V> tree, SearchTreeNodeVisitor<K, V> visitor) {
		inOrder((BSTNode<K, V>) tree.getRoot(), visitor);
	}
	
	/**
	 * In-order traversal from the given <code>root</code>.
	 * 
	 * @param root Root node.
	 * @param visitor {@link SearchTreeNodeVisitor} instance.
	 */
	private void inOrder(BSTNode<K, V> root, SearchTreeNodeVisitor<K, V> visitor) {
		if (root == null) return;
		
		// process left sub-tree
		if (root.getLeft() != null) {
			inOrder(root.getLeft(), visitor);
		}
		
		// process root
		visitor.processNode(root);
		
		// process right sub-tree
		if (root.getRight() != null) {
			inOrder(root.getRight(), visitor);
		}
	}
}