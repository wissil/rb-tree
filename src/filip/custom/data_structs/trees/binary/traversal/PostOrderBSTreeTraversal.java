package filip.custom.data_structs.trees.binary.traversal;

import filip.custom.data_structs.trees.binary.BSTNode;
import filip.custom.data_structs.trees.binary.BinarySearchTree;
import filip.custom.data_structs.trees.traversal.visitors.SearchTreeNodeVisitor;

/**
 * A class that represents a post-order traversal of a {@link BinarySearchTree}.<br>
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in {@link BSTNode} objects.
 * @param <V> Type of values stored in {@link BSTNode} objects.
 */
public class PostOrderBSTreeTraversal<K extends Comparable<? super K>, V> extends BSTreeTraversal<K, V> {

	/**
	 * Creates a new instance of {@link PostOrderBSTreeTraversal}.
	 * 
	 * @param tree Tree being traversed.
	 * @param visitor Visitor active on this traversal.
	 */
	public PostOrderBSTreeTraversal(BinarySearchTree<K, V> tree, SearchTreeNodeVisitor<K, V> visitor) {
		super(tree, visitor);
	}

	@Override
	public void traverse() {
		postOrder((BSTNode<K, V>) tree.getRoot(), visitor);
	}
	
	/**
	 * Pre-order traversal from the given <code>root</code>.
	 * 
	 * @param root Root node.
	 * @param visitor {@link SearchTreeNodeVisitor} instance.
	 */
	private void postOrder(BSTNode<K, V> root, SearchTreeNodeVisitor<K, V> visitor) {
		if (root == null) return;
		
		// process left sub-tree
		if (root.getLeft() != null) {
			postOrder(root.getLeft(), visitor);
		}
		
		// process right sub-tree
		if (root.getRight() != null) {
			postOrder(root.getRight(), visitor);
		}
		
		// process root
		visitor.processNode(root);
	}
}
