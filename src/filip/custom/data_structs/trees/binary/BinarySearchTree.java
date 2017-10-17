package filip.custom.data_structs.trees.binary;


import filip.custom.data_structs.trees.SearchTree;
import filip.custom.data_structs.trees.binary.traversal.InOrderBSTreeTraversal;
import filip.custom.data_structs.trees.nodes.SearchTreeNode;
import filip.custom.data_structs.trees.traversal.visitors.CollectTreeVisitor;
import filip.custom.data_structs.trees.traversal.visitors.FilterTreeVisitor;

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
public class BinarySearchTree<K extends Comparable<? super K>, V> implements SearchTree<K, V>  {

	/**
	 * A root node of this <b>Binary Search Tree</b>.
	 */
	private BSTNode<K, V> root = null;
	
	/**
	 * Default constructor.
	 */
	public BinarySearchTree() {
	}
		
	
	/**
	 * Checks if the given <code>key</code> is <code>null</code>.<br>
	 * If the given <code>key</code> is <code>null</code>, then this method throws an
	 * {@link IllegalArgumentException}, otherwise nothing is returned.
	 * 
	 * @param key Object of interest.
	 */
	private void nullCheck(K key) throws IllegalArgumentException {
		if (key == null) {
			throw new IllegalArgumentException("Key should not be null.");
		}
	}
	
	@Override
	public boolean contains(K key) throws IllegalArgumentException {
		nullCheck(key);
		
		// check if root exists
		if (root == null) {
			return false;
		}
		
		// at this point, root exists
		BSTNode<K, V> tmp = root;
		
		while (tmp != null) {
			// make a comparison
			int compared = tmp.getKey().compareTo(key);
					
			if (compared < 0) {
				// result is right
				tmp = tmp.right;
			} else if (compared > 0) {
				// result is left
				tmp = tmp.left;
			} else {
				// search hit
				return true;
			}
		}
		
		// not found
		return false;
	}
	
	@Override
	public boolean isEmpty() {
		return root == null;
	}	

	@Override
	public boolean insert(K key, V value) throws IllegalArgumentException {
		nullCheck(key);
		
		// 1) create a node to insert
		BSTNode<K, V> toInsert = new BSTNode<>(key, value);
		
		// 2) find a place to insert it
		if (root == null) {
			root = toInsert;
		}
		
		BSTNode<K, V> tmp = root;
		
		while (true) {
			int compared = key.compareTo(tmp.getKey());
			
			if (compared < 0) {
				// go left
				if (tmp.left == null) {
					tmp.left = toInsert;
					return true;
				} else {
					tmp = tmp.left;
				}
			} else if (compared > 0) {
				// go right
				if (tmp.right == null) {
					tmp.right = toInsert;
					return true;
				} else {
					tmp = tmp.right;
				}
			} else {
				// already exists
				return false;
			}
		}
	}

	@Override
	public V remove(K key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void clear() {
		root = null;
	}


	@Override
	public SearchTree<K, V> getLessThan(K high) {		
		return getInterval(null, high);
	}

	@Override
	public SearchTree<K, V> getGreaterThan(K low) {		
		return getInterval(low, null);
	}

	@Override
	public SearchTree<K, V> getInterval(K low, K high) {
		FilterTreeVisitor<K, V> v = new FilterTreeVisitor<>(low, high, this.getClass());	
		new InOrderBSTreeTraversal<>(this, v).traverse();			
		return v.getFiltered();
	}

	@Override
	public String toString() {
		CollectTreeVisitor<K, V> v = new CollectTreeVisitor<>();
		new InOrderBSTreeTraversal<>(this, v).traverse();
		return String.join(System.lineSeparator(), v.getNodes());	
	}
	
	@Override
	public SearchTreeNode<K, V> getRoot() {
		return root;
	}
}
