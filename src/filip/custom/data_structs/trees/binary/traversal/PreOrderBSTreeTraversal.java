package filip.custom.data_structs.trees.binary.traversal;

import filip.custom.data_structs.trees.binary.BSTNode;
import filip.custom.data_structs.trees.binary.BinarySearchTree;
import filip.custom.data_structs.trees.traversal.visitors.SearchTreeNodeVisitor;

/**
 * A class that represents a pre-order traversal of a {@link BinarySearchTree}.<br>
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in {@link BSTNode} objects.
 * @param <V> Type of values stored in {@link BSTNode} objects.
 */
public class PreOrderBSTreeTraversal<K extends Comparable<? super K>, V> implements BSTreeTraversal<K, V> {

	
	@Override
	public void traverse(BinarySearchTree<K, V> tree, SearchTreeNodeVisitor<K, V> visitor) {
		preOrder((BSTNode<K, V>) tree.getRoot(), visitor);
	}
	
	/**
	 * Pre-order traversal from the given <code>root</code>.
	 * 
	 * @param root Root node.
	 * @param visitor {@link SearchTreeNodeVisitor} instance.
	 */
	private void preOrder(BSTNode<K, V> root, SearchTreeNodeVisitor<K, V> visitor) {
		if (root == null) return;
		
		// process root
		visitor.processNode(root);
		
		// process left sub-tree
		if (root.getLeft() != null) {
			preOrder(root.getLeft(), visitor);
		}
		
		// process right sub-tree
		if (root.getRight() != null) {
			preOrder(root.getRight(), visitor);
		}
	}

}
