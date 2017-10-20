package filip.custom.data_structs.trees.factories;

import java.util.Map;

import filip.custom.data_structs.trees.SearchTree;

public interface TreeFactory<K extends Comparable<K>, V> {

	SearchTree<K, V> createFromMap(Map<K, V> entries);
	
}
