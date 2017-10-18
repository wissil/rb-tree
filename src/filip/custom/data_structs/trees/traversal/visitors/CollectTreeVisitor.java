package filip.custom.data_structs.trees.traversal.visitors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import filip.custom.data_structs.trees.nodes.SearchTreeNode;

/**
 * Objects of this class are used to collect the visited nodes in a {@link Collection}.
 * 
 * @author fiilip
 *
 * @param <K> Type of keys in a tree.
 * @param <V> Type of values in a tree.
 */
public class CollectTreeVisitor<K extends Comparable<K>, V> implements SearchTreeNodeVisitor<K, V> {
	
	/**
	 * List of collected nodes.
	 */
	private final List<SearchTreeNode<K, V>> nodes;
	
	/**
	 * Creates a new instance of {@link CollectNodeVisitor}.
	 */
	public CollectTreeVisitor() {
		this.nodes = new ArrayList<>();
	}

	@Override
	public void processNode(SearchTreeNode<K, V> node) {
		nodes.add(node);
	}

	/**
	 * Gets the collection of nodes visited by this visitor.
	 * 
	 * @return Collection of nodes.
	 */
	public Collection<SearchTreeNode<K, V>> getNodes() {
		return Collections.unmodifiableList(nodes);
	}
}
