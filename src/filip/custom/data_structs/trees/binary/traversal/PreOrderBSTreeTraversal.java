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
public class PreOrderBSTreeTraversal<K extends Comparable<K>, V> extends BSTreeTraversal<K, V> {

	/**
	 * Creates a new instance of {@link PreOrderBSTreeTraversal}.
	 * 
	 * @param root Root of the tree being traversed.
	 * @param visitor Visitor active on this traversal.
	 */
	public PreOrderBSTreeTraversal(BSTNode<K, V> root, SearchTreeNodeVisitor<K, V> visitor) {
		super(root, visitor);
	}

	@Override
	public void traverse() {
		preOrder((BSTNode<K, V>) root, visitor);
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
