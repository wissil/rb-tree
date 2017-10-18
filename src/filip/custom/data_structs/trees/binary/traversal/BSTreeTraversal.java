package filip.custom.data_structs.trees.binary.traversal;


import java.util.Objects;

import filip.custom.data_structs.trees.binary.BSTNode;
import filip.custom.data_structs.trees.binary.BinarySearchTree;
import filip.custom.data_structs.trees.traversal.SearchTreeTraversal;
import filip.custom.data_structs.trees.traversal.visitors.SearchTreeNodeVisitor;

/**
 * An abstract class that represents a traversal of any {@link BinarySearchTree}.
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in a {@link BinarySearchTreeNode}.
 * @param <V> Type of values stored in a {@link BinarySearchTreeNode}.
 */
public abstract class BSTreeTraversal<K extends Comparable<K>, V> implements SearchTreeTraversal<K, V> {

	/**
	 * Tree being traversed.
	 */
	final BSTNode<K, V> root;
	
	/**
	 * Visitor that is active on this traversal.
	 */
	final SearchTreeNodeVisitor<K, V> visitor;
	
	/**
	 * Creates a new instance of {@link BSTreeTraversal}.
	 * 
	 * @param root Root of the tree being traversed.
	 * @param visitor Visitor active on this traversal.
	 */
	public BSTreeTraversal(BSTNode<K, V> root, SearchTreeNodeVisitor<K, V> visitor) {
		this.root = Objects.requireNonNull(root);
		this.visitor = Objects.requireNonNull(visitor);
	}
		
	/**
	 * Gets the {@link SearchTreeNodeVisitor} being active on this traversal.
	 * 
	 * @return Visitor active on this traversal.
	 */
	public SearchTreeNodeVisitor<K, V> getVisitor() {
		return visitor;
	}
}
