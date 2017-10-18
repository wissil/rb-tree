package filip.custom.data_structs.trees.binary.util;

import java.util.ArrayList;
import java.util.List;

import filip.custom.data_structs.trees.binary.BSTNode;
import filip.custom.data_structs.trees.binary.BinarySearchTree;

/**
 * A class that implements a {@link String} builder for a given {@link BinarySearchTree}.<br>
 * 
 * The string being built is a <i>pretty</i> string, meaning it graphically demonstrates
 * the structure of a given {@link BinarySearchTree}.
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in a tree.
 * @param <V> Type of values stored in a tree.
 */
public class BSTStringBuilder<K extends Comparable<K>, V> {
	
	/**
	 * Reference to the root of a tree the string is being built for.
	 */
	private final BSTNode<K, V> root;
	
	/**
	 * Creates a new instance of {@link BSTStringBuilder}.
	 * 
	 * @param root Root of a tree the string is being built for.
	 */
	public BSTStringBuilder(BSTNode<K, V> root) {
		this.root = root;
	}
	
	/**
	 * Builds a textual representation of a tree.
	 * 
	 * @return Textual representation of a tree.
	 */
	public String build() {
        if (root == null) return "(empty)";
        return build(root, "", true);
    }

	/**
	 * Builds a textual representation of a tree.
	 * 
	 * @param node Node currently being added to the string being built.
	 * @param prefix String that is built until the moment of calling.
	 * @param isTail Whether or not the current node should be printed as tail.
	 * @return Textual representation of a tree.
	 */
    private String build(BSTNode<K, V> node, String prefix, boolean isTail) {
        StringBuilder builder = new StringBuilder();

        builder.append(prefix + (isTail ? "└── " : "├── "));
        builder.append(node);
        builder.append(System.lineSeparator());
        
        List<BSTNode<K, V>> children = null;
        if (node.getLeft() != null || node.getRight() != null) {
            children = new ArrayList<BSTNode<K, V>>(2);
            if (node.getLeft() != null) children.add((BSTNode<K, V>) node.getLeft());
            if (node.getRight() != null) children.add((BSTNode<K, V>) node.getRight());
        }
        if (children != null) {
            for (int i = 0; i < children.size() - 1; i++) {
                builder.append(build(children.get(i), prefix + (isTail ? "    " : "│   "), false));
            }
            if (children.size() >= 1) {
                builder.append(build(children.get(children.size() - 1), prefix + (isTail ? "    " : "│   "), true));
            }
        }

        return builder.toString();
    }
}
