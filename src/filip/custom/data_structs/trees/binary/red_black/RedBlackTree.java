package filip.custom.data_structs.trees.binary.red_black;


import filip.custom.data_structs.trees.binary.BinarySearchTree;
import filip.custom.data_structs.trees.binary.red_black.RBTNode.Color;

/**
 * A class that represents a <b>Red-Black Tree</b>.<br>
 * 
 * A <b>Red-Black Tree</b> is a special case of a <b>Binary Search Tree</b>,
 * that preserves the optimal arrangement of the nodes, thus guaranteeing that the 
 * worst-case lookup complexity would be <code>O(log n)</code>.<br>
 * 
 * This kind of behavior is accomplished by the feature of auto-balancing that this
 * data structure implements, meaning that the left and a right subtree of any given node
 * of this tree will be balanced.
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in this tree.
 * @param <V> Type of values stored in this tree.
 */
public class RedBlackTree<K extends Comparable<K>, V> extends BinarySearchTree<K, V> {
	
	/**
	 * Root node of this <b>Red-Black Tree</b>.
	 */
	private RBTNode<K, V> root = null;
	
	/**
	 * Default constructor.<br>
	 * Creates a new instance of an empty {@link RedBlackTree}.
	 */
	public RedBlackTree() {
	}
	
	@Override
	protected boolean insertInternal(K key, V value) throws IllegalArgumentException {
		nullCheckKey(key);
		
		// Rule #2: root node is always black
		if (root == null) {
			root = new RBTNode<>(key, value, Color.BLACK);
			return true;
		}
		
		// otherwise, a new node is always red
		RBTNode<K, V> toInsert = new RBTNode<>(key, value, Color.RED);
		
		// Rule #4 violation: parent of a new node is red
		
		// TODO Auto-generated method stub
		return super.insert(key, value);
	}
	
	@Override
	protected V removeInternal(K key) throws IllegalArgumentException {
		nullCheckKey(key);
		
		// TODO Auto-generated method stub
		return super.remove(key);
	}
}
