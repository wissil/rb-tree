package filip.custom.data_structs.trees.binary.traversal;


import filip.custom.data_structs.trees.binary.BinarySearchTree;
import filip.custom.data_structs.trees.traversal.SearchTreeTraversal;

/**
 * An empty interface that represents a traversal of any {@link BinarySearchTree}.
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in a {@link BinarySearchTreeNode}.
 * @param <V> Type of values stored in a {@link BinarySearchTreeNode}.
 */
public interface BSTreeTraversal<K extends Comparable<? super K>, V> 
					extends SearchTreeTraversal<K, V, BinarySearchTree<K, V>> {

	
}
