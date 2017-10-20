package filip.custom.data_structs.trees.binary.red_black;

import filip.custom.data_structs.trees.binary.BSTNode;

/**
 * A class that represents a node of a <b>Red-Black Tree</b>.
 * 
 * @author fiilip
 *
 * @param <K> Type of keys stored in nodes.
 * @param <V> Type of values stored in nodes.
 */
public class RBTNode<K extends Comparable<K>, V> extends BSTNode<K, V> {

	/**
	 * Enumeration of possible {@link RBTNode} colors.
	 * 
	 * @author fiilip
	 *
	 */
	public static enum Color {RED, BLACK}
	
	/**
	 * Color of this node.
	 */
	private Color color;
	
	/**
	 * Parent of this node.
	 */
	private RBTNode<K, V> parent;
	
	/**
	 * Creates a new {@link RBTNode}.
	 * 
	 * @param key Key contained by this node.
	 * @param value Value contained by this node.
	 * @param color Color of this node.
	 * @param parent Parent node of this node.
	 */
	public RBTNode(K key, V value, Color color, RBTNode<K, V> parent) {
		super(key, value);
		this.color = color;
		this.parent = parent;
	}
	
	/**
	 * Gets the color of this node.
	 * 
	 * @return Color of this node.
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Sets the color of this node to a given <code>color</code>.
	 * 
	 * @param color New color of this node.
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * Gets the parent node of this node.
	 * 
	 * @return Parent node of this node.
	 */
	public RBTNode<K, V> getParent() {
		return parent;
	}
	
	/**
	 * Sets the parent node of this node.
	 * 
	 * @param parent Parent node of this node.
	 */
	public void setParent(RBTNode<K, V> parent) {
		this.parent = parent;
	}
}
