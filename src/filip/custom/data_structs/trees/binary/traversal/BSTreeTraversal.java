package filip.custom.data_structs.trees.binary.traversal;


import java.util.Objects;

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
public abstract class BSTreeTraversal<K extends Comparable<? super K>, V> implements SearchTreeTraversal<K, V> {

	/**
	 * Tree being traversed.
	 */
	final BinarySearchTree<K, V> tree;
	
	/**
	 * Visitor that is active on this traversal.
	 */
	final SearchTreeNodeVisitor<K, V> visitor;
	
	/**
	 * Creates a new instance of {@link BSTreeTraversal}.
	 * 
	 * @param tree Tree being traversed.
	 * @param visitor Visitor active on this traversal.
	 */
	public BSTreeTraversal(BinarySearchTree<K, V> tree, SearchTreeNodeVisitor<K, V> visitor) {
		this.tree = Objects.requireNonNull(tree);
		this.visitor = Objects.requireNonNull(visitor);
	}
	
	/**
	 * Gets the {@link BinarySearchTree} being traversed.
	 * 
	 * @return Tree being traversed.
	 */
	public BinarySearchTree<K, V> getTree() {
		return tree;
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
