package filip.custom.data_structs.trees.binary.red_black.oper.remove;

import filip.custom.data_structs.trees.binary.BSTNode;
import filip.custom.data_structs.trees.binary.red_black.RBTNode;
import filip.custom.data_structs.trees.binary.red_black.RBTNode.Color;
import filip.custom.data_structs.trees.nodes.SearchTreeNode;

/**
 * A class that represents a removal of element from a <b>Red-Black Tree</b>.<br>
 * 
 * The actual algorithm that performs the removal is implemented here.<br>
 * The algorithm is based on the pseudo-code from the book <i>Introduction to Algorithms 3rd Edition</i>.
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in a tree.
 * @param <V> Type of values stored in a tree.
 */
public class RBTRemoval<K extends Comparable<K>, V> extends AbstractRBTRemoval<K, V> {
		
	/**
	 * Creates a new instance of {@link RBTRemoval}.
	 * 
	 * @param root Root of the tree calling this removal.
	 */
	public RBTRemoval(RBTNode<K, V> root) {
		super(root);
	}

	@Override
	public SearchTreeNode<K, V> remove(K key) {
		// find a node to remove
		RBTNode<K, V> z = findNode(key);
		
		if (z == null) {
			// node with a given key not found
			return root;
		}
		
		// node with a give key was found
		RBTNode<K, V> x = null;
		RBTNode<K, V> y = z;
		
		Color yOriginalColor = y.getColor();
		
		if (z.getLeft() == null) {
			x = (RBTNode<K, V>) z.getRight();
			transplant(z, (RBTNode<K, V>) z.getRight());
		} else if (z.getRight() == null) {
			x = (RBTNode<K, V>) z.getLeft();
			transplant(z, (RBTNode<K, V>) z.getLeft());
		} else {
			y = findMin(z.getRight());
			yOriginalColor = y.getColor();
			x = (RBTNode<K, V>) y.getRight();
			
			if (y.getParent().equals(z)) {
				x.setParent(y);
			} else {
				transplant(y, (RBTNode<K, V>) y.getRight());
				y.setRight(z.getRight());
				((RBTNode<K, V>) y.getRight()).setParent(y);
			}
			
			transplant(z, y);
			y.setLeft(z.getLeft());
			((RBTNode<K, V>) y.getLeft()).setParent(y);
			y.setColor(z.getColor());
		}
		
		if (yOriginalColor.equals(Color.BLACK)) {
			rebalance(x);
		}
		
		return root;
	}
	
	/**
	 * Performs the re-balancing of the tree.
	 * 
	 * @param x
	 */
	private void rebalance(RBTNode<K, V> x) {
		while (!(x.equals(root)) && (x.getClass().equals(Color.BLACK))) {
			if (x.equals(x.getParent().getLeft())) {
				RBTNode<K, V> w = (RBTNode<K, V>) x.getParent().getRight();
				
				if (w.getColor().equals(Color.RED)) {
					w.setColor(Color.BLACK);
					x.getParent().setColor(Color.RED);
					leftRotate(x.getParent());
					w = (RBTNode<K, V>) x.getParent().getRight();
				}
				
				if (((RBTNode<K, V>) w.getLeft()).getColor().equals(Color.BLACK) && 
						((RBTNode<K, V>) w.getRight()).getColor().equals(Color.BLACK)) {
					w.setColor(Color.RED);
					x = x.getParent();
					continue;
				} else if (((RBTNode<K, V>) w.getRight()).getColor().equals(Color.BLACK)) {
					((RBTNode<K, V>) w.getLeft()).setColor(Color.BLACK);
					w.setColor(Color.RED);
					rightRotate(w);
					w = (RBTNode<K, V>) x.getParent().getRight();
				}
				
				if (((RBTNode<K, V>) w.getRight()).getColor().equals(Color.RED)) {
					w.setColor(x.getParent().getColor());
					x.getParent().setColor(Color.BLACK);
					((RBTNode<K, V>) w.getRight()).setColor(Color.BLACK);
					leftRotate(x.getParent());
					x = root;
				}
				
			} else {
				RBTNode<K, V> w = (RBTNode<K, V>) x.getParent().getLeft();
				
				if (w.getColor().equals(Color.RED)) {
					w.setColor(Color.BLACK);
					x.getParent().setColor(Color.RED);
					rightRotate(x.getParent());
					w = (RBTNode<K, V>) x.getParent().getLeft();
				}
				
				if (((RBTNode<K, V>) w.getRight()).getColor().equals(Color.BLACK) && 
						((RBTNode<K, V>) w.getLeft()).getColor().equals(Color.BLACK)) {
					w.setColor(Color.RED);
					x = x.getParent();
					continue;
					
				} else if (((RBTNode<K, V>) w.getLeft()).equals(Color.BLACK)) {
					((RBTNode<K, V>) w.getRight()).setColor(Color.BLACK);
					w.setColor(Color.RED);
					leftRotate(w);
					w = (RBTNode<K, V>) x.getParent().getLeft();
				}
				
				if (((RBTNode<K, V>) w.getLeft()).getColor().equals(Color.RED)) {
					w.setColor(x.getParent().getColor());
					x.getParent().setColor(Color.BLACK);
					((RBTNode<K, V>) w.getLeft()).setColor(Color.BLACK);
					rightRotate(x.getParent());
					x = root;
				}
			}
		}
		
		x.setColor(Color.BLACK);
	}

	/**
	 * Finds the minimum node in the subtree rooted at <code>node</code>.
	 * 
	 * @param node Root of the subtree the minimum is being searched for.
	 * @return The minimum node in a subtree rooted in <code>node</code>.
	 */
	private RBTNode<K, V> findMin(BSTNode<K, V> node) {
		while (node.getLeft() != null) node = node.getLeft();
		return (RBTNode<K, V>) node;
	}
	
	/**
	 * Replaces a <code>target</code> subtree as a child of it's parent 
	 * with another subtree, <code>with</code>.
	 * 
	 * @param target Subtree to be replaced.
	 * @param with Subtree to become a child of a root of replaced subtree.
	 */
	private void transplant(RBTNode<K, V> target, RBTNode<K, V> with){ 
        if (parent(target) == null) {
            root = with;
        } else if (isLeftChild(target, parent(target))){
        		parent(target).setLeft(with);
        } else {
        		parent(target).setRight(with);
        }
        with.setParent(parent(target));
	}

	/**
	 * Finds a node with a given <code>key</code> in a structure of 
	 * a <b>Red-Black Tree</b>.
	 * 
	 * @param key Key of the node being searched for.
	 * @return A node with a given <code>key</code> if such node exists,
	 * and <code>null</code> otherwise.
	 */
	private RBTNode<K, V> findNode(K key) {
		RBTNode<K, V> tmp = root;
		
		while (true) {
			// not found
			if (tmp == null) return null;
			
			int compared = key.compareTo(tmp.getKey());
			
			if (compared < 0) {
				// go left
				tmp = (RBTNode<K, V>) tmp.getLeft();
			} else if (compared > 0) {
				// go right
				tmp = (RBTNode<K, V>) tmp.getRight();
			} else {
				// found
				return tmp;
			}
		}
	}
	
	
}
