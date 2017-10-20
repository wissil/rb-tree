package filip.custom.data_structs.trees.factories;

import java.util.List;

import filip.custom.data_structs.trees.SearchTree;
import filip.custom.data_structs.trees.binary.BinarySearchTree;

public class BSTFactory<K extends Comparable<K>, V> implements TreeFactory<K, V> {

	@Override
	public SearchTree<K, V> createFromList(List<TreeEntry<K, V>> entries) {
		BinarySearchTree<K, V> tree = new BinarySearchTree<>();	
		entries.forEach(e -> tree.insert(e.getKey(), e.getValue()));
		return tree;
	}

}
