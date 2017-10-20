package filip.custom.data_structs.trees.factories;

import java.util.List;

import filip.custom.data_structs.trees.SearchTree;
import filip.custom.data_structs.trees.binary.red_black.RedBlackTree;

public class RBTFactory<K extends Comparable<K>, V> implements TreeFactory<K, V> {


	@Override
	public SearchTree<K, V> createFromList(List<TreeEntry<K, V>> entries) {
		RedBlackTree<K, V> tree = new RedBlackTree<>();
		entries.forEach(e -> tree.insert(e.getKey(), e.getValue()));
		return tree;
	}

}
