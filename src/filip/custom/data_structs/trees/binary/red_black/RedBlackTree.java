package filip.custom.data_structs.trees.binary.red_black;


import filip.custom.data_structs.trees.binary.BinarySearchTree;
import filip.custom.data_structs.trees.binary.red_black.oper.insert.RBTInsertion;
import filip.custom.data_structs.trees.binary.red_black.oper.remove.RBTRemoval;

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
	
	@Override
	public boolean insert(K key, V value) throws IllegalArgumentException {
		RBTInsertion<K, V> i = new RBTInsertion<>((RBTNode<K, V>) root);
		root = (RBTNode<K, V>) i.insert(key, value);
		return i.isInserted();
	}
	
	@Override
	public V remove(K key) throws IllegalArgumentException {
		RBTRemoval<K, V> r = new RBTRemoval<>((RBTNode<K, V>) root);
		root = (RBTNode<K, V>) r.remove(key);
		return r.getValueRemoved();
	}
}
