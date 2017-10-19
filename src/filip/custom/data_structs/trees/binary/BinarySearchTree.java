package filip.custom.data_structs.trees.binary;

import filip.custom.data_structs.trees.SearchTree;

/**
 * This class represents any <b>Binary Search Tree</b>.<br>
 * 
 * It is a special case of the {@link SearchTree} in which any parent node has
 * exactly two children nodes.
 * 
 * @author fiilip
 *
 * @param <K> {@link Comparable} parameter of this interface that represents the key 
 * objects that are stored in this <b>Search Tree</b>. For the purposes of a <b>Search Tree</b>,
 * it's keys need to be comparable to one another so that the algorithm is able to calculate the object's placement
 * in the data structure.
 *
 * @param <V> Parameter of this interface representing the value objects stored in this binary tree.
 */
public class BinarySearchTree<K extends Comparable<K>, V> extends AbstractBST<K, V>  {
	
	@Override
	public boolean insert(K key, V value) throws IllegalArgumentException {
		BSTInsertion<K, V> i = new BSTInsertion<>(root);
		root = i.insert(key, value);
		return i.isInserted();
	}
	
	@Override
	public V remove(K key) throws IllegalArgumentException {
		BSTRemoval<K, V> r = new BSTRemoval<>(root);
		root = (BSTNode<K, V>) r.remove(key);
		return r.getValueRemoved();
	}
}
