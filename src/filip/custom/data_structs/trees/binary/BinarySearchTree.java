package filip.custom.data_structs.trees.binary;

import filip.custom.data_structs.trees.SearchTree;
import filip.custom.data_structs.trees.binary.oper.insert.BSTInsertion;
import filip.custom.data_structs.trees.binary.oper.remove.BSTRecRemoval;
import filip.custom.data_structs.trees.operations.EntryInsertion;
import filip.custom.data_structs.trees.operations.EntryRemoval;

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
	protected EntryInsertion<K, V> getInsertion() {
		return new BSTInsertion<>(root);
	}

	@Override
	protected EntryRemoval<K, V> getRemoval() {
		return new BSTRecRemoval<>(root);
	}
}
