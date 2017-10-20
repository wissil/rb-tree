package filip.custom.data_structs.trees.binary;

import java.util.Iterator;

import filip.custom.data_structs.trees.SearchTree;
import filip.custom.data_structs.trees.binary.iterators.BSTIterator;
import filip.custom.data_structs.trees.binary.traversal.InOrderBSTreeTraversal;
import filip.custom.data_structs.trees.binary.util.BSTStringBuilder;
import filip.custom.data_structs.trees.traversal.visitors.FilterTreeVisitor;

/**
 * An abstract class that represents any tree that conforms to the rules of
 * a <b>Binary Search Tree</b>.
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in this tree.
 * @param <V> Type of values stored in this tree.
 */
public abstract class AbstractBST<K extends Comparable<K>, V> implements SearchTree<K, V> {
	
	/**
	 * Root node of this tree.
	 */
	protected BSTNode<K, V> root;
	
	/**
	 * Count of currently stored entries in this tree.
	 */
	private int size;
	
	/**
	 * Creates a new instance of {@link AbstractBST}.
	 * 
	 * @param insertion Type of entry insertion being used by this tree.
	 * @param removal Type of entry removal being used by this tree.
	 */
	protected AbstractBST() {
		this.size = 0;
		this.root = null;
	}
		
	@Override
	public boolean contains(K key) throws IllegalArgumentException {
		return get(key) != null;
	}
	
	@Override
	public boolean isEmpty() {
		return root == null;
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
		new InOrderBSTreeTraversal<>(root, v).traverse();			
		return v.getFiltered();
	}

	@Override
	public String toString() {
		return new BSTStringBuilder<>(root).build();
	}

	@Override
	public Iterator<Entry<K, V>> iterator() {
		return new BSTIterator<>(root);
	}

	@Override
	public int size() {		
		return size;
	}

	@Override
	public V get(K key) {
		nullCheckKey(key);
				
		BSTNode<K, V> tmp = root;
		
		while (tmp != null) {
			// make a comparison
			int compared = tmp.getKey().compareTo(key);
					
			if (compared < 0) {
				// result is right
				tmp = tmp.getRight();
			} else if (compared > 0) {
				// result is left
				tmp = tmp.getLeft();
			} else {
				// search hit
				return tmp.getValue();
			}
		}
		
		// not found
		return null;
	}
	
	
	/**
	 * Checks if the given <code>key</code> is <code>null</code>.<br>
	 * 
	 * @param key Key of interest.
	 * @throws IllegalArgumentException if a given <code>key</code> is <code>null</code>.
	 */
	private void nullCheckKey(K key) throws IllegalArgumentException {
		if (key == null) {
			throw new IllegalArgumentException("Key should not be null.");
		}
	}
}
