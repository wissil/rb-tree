package filip.custom.data_structs.trees.binary.oper;

import filip.custom.data_structs.trees.binary.BSTNode;
import filip.custom.data_structs.trees.nodes.SearchTreeNode;
import filip.custom.data_structs.trees.operations.EntryRemoval;

/**
 * A class that represents a removal of element from a <b>Binary Search Tree</b>.<br>
 * 
 * The actual algorithm that performs the removal is implemented here.
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in a tree.
 * @param <V> Type of values stored in a tree.
 */
public class BSTRemoval<K extends Comparable<K>, V> implements EntryRemoval<K, V> {
	
	/**
	 * Root of the tree calling this removal.
	 */
	protected BSTNode<K, V> root;
	
	/**
	 * Value of the entry removed by the last call to method <code>remove</code>.
	 */
	protected V removed;
	
	/**
	 * Creates a new instance of {@link BSTRemoval}.
	 * 
	 * @param root Root of the tree calling this removal.
	 */
	public BSTRemoval(BSTNode<K, V> root) {
		this.root = root;
		this.removed = null;
	}

	@Override
	public SearchTreeNode<K, V> remove(K key) {
		/* 1) Find the node to be deleted and it's parent */
		BSTNode<K, V> parent = null;
		BSTNode<K, V> toDelete = root;

		// if the node to be deleted is left child of it's parent
		boolean isLeft = false;

		while (true) {
			// searched object not found if
			if (toDelete == null) removed = null;

			int compared = key.compareTo(toDelete.getKey());

			if (compared > 0) {
				// go right
				isLeft = false;
				parent = toDelete;
				toDelete = toDelete.getRight();
			} else if (compared < 0) {
				// go left
				isLeft = true;
				parent = toDelete;
				toDelete = toDelete.getLeft();
			} else {
				// object found
				break;
			}
		}
		/* At this point, the node to delete and it's parent are found */
		removed = toDelete.getValue();

		/*
		 * Three possible scenarios:
		 * 1) toDelete is a leaf node, ie. has no children
		 * 2) toDelete has only one child
		 * 3) toDelete has two children
		 */
		int children = toDelete.getNumberOfChildren();	

		if (children == 0) {			
			// 1) leaf node			
			if (parent == null) {
				// root is being deleted
				root = null;
			} else if (parent.getLeft().getKey().equals(key)) {
				// left child is being deleted
				parent.setLeft(null);
			} else {
				// right child is being deleted
				parent.setRight(null);
			}

		} else if (children == 1) {			
			// 2) one child node	
			BSTNode<K, V> child = null;

			if (toDelete.getLeft() != null) {
				// has left subtree
				child = toDelete.getLeft();
			} else {
				// has right subtree
				child = toDelete.getRight();
			}

			if (parent == null) {
				// root is being deleted
				root = child;
			} else {
				// not root is being deleted
				if (isLeft) {
					parent.setLeft(child);
				} else {
					parent.setRight(child);
				}
			}

		} else if (children == 2) {
			// 3) two child nodes

			BSTNode<K, V> left = toDelete.getLeft();
			BSTNode<K, V> right = toDelete.getRight();

			// find max in left subtree
			BSTNode<K, V> maxRight = left;
			BSTNode<K, V> tmpPar = maxRight;

			while (maxRight.getRight() != null) {
				tmpPar = maxRight;
				maxRight = maxRight.getRight();
			}

			BSTNode<K, V> sub = maxRight;

			if (maxRight.getLeft() != null) {
				tmpPar.setRight(maxRight.getLeft());
			}

			if (parent == null) {
				root = sub;
			} else if (isLeft) {
				parent.setLeft(sub);
			} else {
				parent.setRight(sub);
			}

			if (left.getLeft() != null) {
				sub.setLeft(left);
			}
			if (right.getRight() != null) {
				sub.setRight(right);
			}

		} else {
			throw new IllegalArgumentException(
					String.format("Can't delete a node with an illegal number of child nodes: %d.", children));
		}

		return root;
	}

	@Override
	public V getValueRemoved() {
		return removed;
	}
}
