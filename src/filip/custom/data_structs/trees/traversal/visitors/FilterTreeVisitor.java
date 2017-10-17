package filip.custom.data_structs.trees.traversal.visitors;

import java.lang.reflect.InvocationTargetException;

import filip.custom.data_structs.trees.SearchTree;
import filip.custom.data_structs.trees.nodes.SearchTreeNode;

/**
 * A class that filters a {@link SearchTree} defined by it's {@link SearchTreeNode} root.<br>
 * 
 * The resulting {@link SearchTree} contains only the elements that have passed the filter.
 * 
 * @author fiilip
 *
 * @param <K> Type of keys in a tree.
 * @param <V> Type of values in a tree.
 */
public class FilterTreeVisitor<K extends Comparable<? super K>, V> implements SearchTreeNodeVisitor<K, V> {

	/**
	 * Lower limit for the keys being processed.
	 */
	private final K lowLimit;
	
	/**
	 * Upper limit for the keys being processed.
	 */
	private final K upLimit;
	
	/**
	 * Filtered tree.
	 */
	private SearchTree<K, V> filtered;
	
	/**
	 * Creates a new instance of {@link FilterTreeVisitor}.<br>
	 * If a given limit is passed in as <code>null</code>, it will be ignored.
	 * 
	 * @param lowLimit All elements lower than this value will be filtered.
	 * @param upLimit All elements higher than this value will be filtered.
	 */
	@SuppressWarnings("unchecked")
	public FilterTreeVisitor(K lowLimit, K upLimit, Class<?> cls) {
		this.lowLimit = lowLimit;
		this.upLimit = upLimit;
		try {
			this.filtered = (SearchTree<K, V>) cls.getConstructors()[0].newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | 
				InvocationTargetException | SecurityException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void processNode(SearchTreeNode<K, V> node) {		
		int cmpUp;
		int cmpDwn;
		
		K key = node.getKey();
		V val = node.getValue();
		
		if (lowLimit == null && upLimit == null) {
			filtered.insert(key, val);
		} else if (lowLimit == null && upLimit != null) {
			cmpUp = key.compareTo(upLimit);
			if (cmpUp < 0) {
				filtered.insert(key, val);
			}
		} else if (lowLimit != null && upLimit == null) {
			cmpDwn = key.compareTo(lowLimit);
			if (cmpDwn > 0) {
				filtered.insert(key, val);
			}
		} else {
			cmpUp = key.compareTo(upLimit);
			cmpDwn = key.compareTo(lowLimit);
			
			if (cmpUp < 0 && cmpDwn > 0) {
				filtered.insert(key, val);
			}
		}
	}
	
	/**
	 * Gets the filtered tree.
	 * 
	 * @return Filtered tree.
	 */
	public SearchTree<K, V> getFiltered() {
		return filtered;
	}

}
