package filip.custom.data_structs.trees.binary.oper.insert;

import filip.custom.data_structs.trees.binary.BSTNode;

/**
 * A class that represents an insertion to a <b>Binary Search Tree</b>.<br>
 * 
 * The actual algorithm that performs the insertion is implemented here.
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in a tree.
 * @param <V> Type of values stored in a tree.
 */
public class BSTInsertion<K extends Comparable<K>, V> extends AbstractBSTInsertion<K, V> {
	
	/**
	 * Creates a new instance of {@link BSTInsertion}.
	 * 
	 * @param root Root of the tree calling this insertion.
	 */
	public BSTInsertion(BSTNode<K, V> root) {
		super(root);
	}

	@Override
	public BSTNode<K, V> insert(K key, V value) {
		// 1) create a node to insert
		BSTNode<K, V> toInsert = new BSTNode<>(key, value);

		// 2) find a place to insert it
		if (root == null) {
			root = toInsert;
			inserted = true;
			return root;
		}

		BSTNode<K, V> tmp = root;

		while (true) {
			int compared = key.compareTo(tmp.getKey());

			if (compared < 0) {
				// go left
				if (tmp.getLeft() == null) {
					tmp.setLeft(toInsert);
					inserted = true;
					break;
				} else {
					tmp = tmp.getLeft();
				}
			} else if (compared > 0) {
				// go right
				if (tmp.getRight() == null) {
					tmp.setRight(toInsert);
					inserted = true;
					break;
				} else {
					tmp = tmp.getRight();
				}
			} else {
				// already exists
				inserted = false;
				break;
			}
		}
		
		return root;
	}
}
