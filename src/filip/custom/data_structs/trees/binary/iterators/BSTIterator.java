package filip.custom.data_structs.trees.binary.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Stack;

import filip.custom.data_structs.trees.SearchTree;
import filip.custom.data_structs.trees.binary.BSTNode;
import filip.custom.data_structs.trees.binary.BinarySearchTree;

/**
 * Iterates over the {@link BinarySearchTree} in-order.
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in a tree.
 * @param <V> Type of values stored in a tree.
 */
public class BSTIterator<K extends Comparable<K>, V> implements Iterator<SearchTree.Entry<K, V>> {
	
	/**
	 * Auxiliary stack that holds the nodes.
	 */
	private final Stack<BSTNode<K, V>> stack;
	
	/**
	 * Creates a new instance of {@link BSTIterator}.
	 */
	public BSTIterator(BSTNode<K, V> root) {
		Objects.requireNonNull(root);
		this.stack = new Stack<>();
		
		pushAll(root);
	}
	
	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	@Override
	public BSTNode<K, V> next() {
		if (!hasNext()) throw new NoSuchElementException("No more elements in a tree.");
		
		BSTNode<K, V> node = stack.pop();
		pushAll(node.getRight());
		return node;
	}

	private void pushAll(BSTNode<K, V> node) {
        for (; node != null; stack.push(node), node = node.getLeft());
    }
}
