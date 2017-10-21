package filip.custom.data_structs.trees.binary.oper.remove;

import filip.custom.data_structs.trees.binary.BSTNode;
import filip.custom.data_structs.trees.nodes.SearchTreeNode;

/**
 * A class that represents a recursive removal of element from a <b>Binary Search Tree</b>,
 * as opposed to iterative removal.<br>
 * 
 * The actual algorithm that performs the removal is implemented here.
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in a tree.
 * @param <V> Type of values stored in a tree.
 */
public class BSTRecRemoval<K extends Comparable<K>, V> extends AbstractBSTRemoval<K, V> {
	
	/**
	 * Creates a new instance of {@link BSTRecRemoval}.
	 * 
	 * @param root Root of the tree this removal works upon.
	 */
	public BSTRecRemoval(BSTNode<K, V> root) {
		super(root);
	}

	@Override
	public SearchTreeNode<K, V> remove(K key) {
		return remove(root, key);
	}

	/**
	 * Recursive removal method.
	 * 
	 * @param node Root of the current subtree in a recursion.
	 * @param key Key of the node searching to be deleted.
	 * @return Root of the tree.
	 */
	private BSTNode<K, V> remove(BSTNode<K, V> node, K key) {
		if (node == null) return node;
		
		int compared = key.compareTo(node.getKey());
		if (compared < 0) {
			// go left
			node.setLeft(remove(node.getLeft(), key));
		} else if (compared > 0) {
			// go right
			node.setRight(remove(node.getRight(), key));
		} else {
			// search hit
			int children = node.getNumberOfChildren();
			
			switch (children) {
				case 0: return deleteNoChildren(node);
				case 1: return deleteOneChild(node);
				case 2: return deleteTwoChildren(node);
				default: throw new IllegalArgumentException(
						"Node with more than two child nodes found in a BST!");
			}
		}
		return node;
	}

	/**
	 * Performs the removal of a {@link BSTNode} node with two children.
	 * 
	 * @param node {@link BSTNode} with two child nodes.
	 * @return The first node greater than the deleted node.
	 */
	private BSTNode<K, V> deleteTwoChildren(BSTNode<K, V> node) {
		// the least node which is still greater than the one deleted
		BSTNode<K, V> replacementNode = findMin(node.getRight()); 
		
		// left subtree
		BSTNode<K, V> left = node.getLeft();
		
		// the min-value node's right is now set as all the right nodes minus itself
		replacementNode.setRight(deleteDoubleNode(node.getRight())); 
		replacementNode.setLeft(left);
		return replacementNode;
	}

	/**
	 * Performs the removal of a {@link BSTNode} node with one child.
	 * 
	 * @param node {@link BSTNode} with one child node.
	 * @return The child node of a deleted node.
	 */
	private BSTNode<K, V> deleteOneChild(BSTNode<K, V> node) {
		if (node.getLeft() == null) {
			// has only right child
			return node.getRight();
		} else {
			// has only left child
			return node.getLeft();
		}
	}

	/**
	 * Performs the removal of a {@link BSTNode} node with no children.
	 * 
	 * @param node {@link BSTNode} with no child nodes.
	 * @return <code>null</code>, since the node after removal will be <code>null</code>.
	 */
	private BSTNode<K, V> deleteNoChildren(BSTNode<K, V> node) {
		return null;
	}
	
	
	private BSTNode<K, V> deleteDoubleNode(BSTNode<K, V> node) {
		if(node.getLeft() == null) {
			// at the bottom of the nodes
			return node.getRight();
		}
		else {
			// set the left node as the right of the one we found at the bottom.
			node.setLeft(deleteDoubleNode(node.getLeft()));
		}
		return node;
	}
	
	/**
	 * Finds the minimum node in the subtree starting from root <code>node</code>.
	 * 
	 * @param node Root of the subtree where minimum node is being searched for.
	 * @return Minimum node of a subtree rooted in <code>node</code>.
	 */
	private BSTNode<K, V> findMin(BSTNode<K, V> node) {
		while(node.getLeft() != null) {
			node = node.getLeft();
		}
		return node;
	}
}
