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
public class InOrderBSTreeTraversal<K extends Comparable<K>, V> extends BSTreeTraversal<K, V> {

	/**
	 * Creates a new instance of {@link InOrderBSTreeTraversal}.
	 * 
	 * @param tree Root of the tree being traversed.
	 * @param visitor Visitor active on this traversal.
	 */
	public InOrderBSTreeTraversal(BSTNode<K, V> root, SearchTreeNodeVisitor<K, V> visitor) {
		super(root, visitor);
	}

	@Override
	public void traverse() {
		inOrder((BSTNode<K, V>) root, visitor);
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
