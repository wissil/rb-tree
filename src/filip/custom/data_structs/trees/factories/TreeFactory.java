package filip.custom.data_structs.trees.factories;

import java.util.List;

import filip.custom.data_structs.trees.SearchTree;

public interface TreeFactory<K extends Comparable<K>, V> {

	SearchTree<K, V> createFromList(List<TreeEntry<K, V>> entries);
	
}
