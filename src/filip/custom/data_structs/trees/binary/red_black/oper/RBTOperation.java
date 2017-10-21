package filip.custom.data_structs.trees.binary.red_black.oper;

import filip.custom.data_structs.trees.binary.red_black.RBTNode;
import filip.custom.data_structs.trees.binary.red_black.RBTNode.Color;

/**
 * An abstract class that represents any operation (primarily, insertion and removal)
 * on a <b>Red-Black Tree</b>.
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in a tree.
 * @param <V> Type of values stored in a tree.
 */
public abstract class RBTOperation<K extends Comparable<K>, V> {

	/**
	 * Root of the tree calling this removal.
	 */
	protected RBTNode<K, V> root;
	
	/**
	 * Creates a new instance of {@link RBTOperation}.
	 * 
	 * @param root Root of the that calls this operation.
	 */
	protected RBTOperation(RBTNode<K, V> root) {
		this.root = root;
	}
	
	/**
	 * Gets the parent node of a given <code>node</code>.
	 * 
	 * @param node Node of interest.
	 * @return Parent of a given <code>node</code>.
	 */
	protected RBTNode<K, V> parent(RBTNode<K, V> node) {
		return node.getParent();
	}
	
	/**
	 * Gets the grandparent node of a given <code>node</code>.
	 * 
	 * @param node Node of interest.
	 * @return Grandparent of a given <code>node</code>.
	 */
	protected RBTNode<K, V> grandparent(RBTNode<K, V> node) {
		return node.getParent().getParent();
	}
	
	/**
	 * Performs a right rotation about a given node <code>n</code>.
	 * 
	 * @param n Node about which the right rotation is called.
	 */
	protected void rightRotate(RBTNode<K, V> n) {
        if (parent(n) != null) {
        	
        		if (isLeftChild(n, parent(n))) {
        			parent(n).setLeft(n.getLeft());
        		} else {
        			parent(n).setRight(n.getLeft());
        		}
        		
        		((RBTNode<K, V>) n.getLeft()).setParent(parent(n));
        		n.setParent((RBTNode<K, V>) n.getLeft());

        		if (n.getLeft().getRight() != null) {
        			((RBTNode<K, V>) n.getLeft().getRight()).setParent(n);
        		}
        		
        		n.setLeft(n.getLeft().getRight());
        		n.getParent().setRight(n);

        } else {
        		// need to rotate root
        		RBTNode<K, V> left = (RBTNode<K, V>) root.getLeft();
        		root.setLeft(root.getLeft().getRight());
        		((RBTNode<K, V>) left.getRight()).setParent(root);
        		root.setParent(left);

        		left.setRight(root);
        		left.setParent(null);
        		
        		root = left;
        }
    }
	
	/**
	 * Performs a left rotation about a given node <code>n</code>.
	 * 
	 * @param n Node about which the left rotation is called.
	 */
	protected void leftRotate(RBTNode<K, V> n) {
        if (parent(n) != null) {
        	
            if (isLeftChild(n, parent(n))) {
            		parent(n).setLeft(n.getRight());
            } else {
            		parent(n).setRight(n.getRight());
            }
            
            ((RBTNode<K, V>) n.getRight()).setParent(n.getParent());
            n.setParent((RBTNode<K, V>) n.getRight());
            
            if (n.getRight().getLeft() != null) {
            		((RBTNode<K, V>) n.getRight().getLeft()).setParent(n);
            }
            
            n.setRight(n.getRight().getLeft());
            parent(n).setLeft(n);
            
        } else {
        		// need to rotate root
            RBTNode<K, V> right = (RBTNode<K, V>) root.getRight();
            root.setRight(right.getLeft());
            ((RBTNode<K, V>) right.getLeft()).setParent(root);
            root.setParent(right);
            
            right.setLeft(root);
            right.setParent(null);
            
            root = right;
        }
    }

	/**
	 * Checks whether the given <code>child</code> is a left child
	 * of a given <code>parent</code>.
	 * 
	 * @param child Child node.
	 * @param parent Parent node.
	 * @return <code>true</code> if the <code>child</code> is a left child, and <code>false</code> otherwise.
	 * @throws IllegalArgumentException If a provided <code>child</code> node doesn't have
	 * provided <code>parent</code> node as it's parent or any of the given nodes are <code>null</code>.
	 */
	protected boolean isLeftChild(RBTNode<K, V> child, RBTNode<K, V> parent) {
		if (child == null) {
			throw new IllegalArgumentException("Provided child node is null");
		}
		
		if (parent == null) {
			throw new IllegalArgumentException("Provided parent node is null");
		}
		
		if (!child.getParent().equals(parent)) {
			throw new IllegalArgumentException("Provided parent node is not a parent to a provided child node");
		}
		return child.equals(parent.getLeft());
	}
	
	/**
	 * Checks whether the given <code>child</code> is a right child
	 * of a given <code>parent</code>.
	 * 
	 * @param child Child node.
	 * @param parent Parent node.
	 * @return <code>true</code> if the <code>child</code> is a left child, and <code>false</code> otherwise.
	 * @throws IllegalArgumentException If a provided <code>child</code> node doesn't have
	 * provided <code>parent</code> node as it's parent or any of the given nodes are <code>null</code>.
	 */
	protected boolean isRightChild(RBTNode<K, V> child, RBTNode<K, V> parent) {
		return !isLeftChild(child, parent);
	}
	
	/**
	 * Checks whether a given node <code>n</code> is black.<br>
	 * If a node is not black, it is red.<br>
	 * 
	 * <code>null</code> nodes are considered black.
	 * 
	 * @param n Node of interest.
	 * @return <code>true</code> if <code>n</code> is black, and <code>false</code> if it is red.
	 */
	protected boolean isBlack(RBTNode<K, V> n) {
		return n == null || n.getColor().equals(Color.BLACK);
	}
	
	/**
	 * Checks whether a given node <code>n</code> is red.<br>
	 * If a node is not red, it is black.<br>
	 * 
	 * <code>null</code> nodes are considered black.
	 * 
	 * @param n Node of interest.
	 * @return <code>true</code> if <code>n</code> is red, and <code>false</code> if it is black.
	 */
	protected boolean isRed(RBTNode<K, V> n) {
		return !isBlack(n);
	}
}
