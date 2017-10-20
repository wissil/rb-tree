package filip.custom.data_structs.trees.factories;

import filip.custom.data_structs.trees.nodes.SearchTreeNode;

public class TreeEntry<K extends Comparable<K>, V> extends SearchTreeNode<K, V> {

	public TreeEntry(K key, V value) {
		super(key, value);
	}

}
