package filip.custom.data_structs.trees;

import filip.custom.data_structs.trees.binary.BinarySearchTree;
import filip.custom.data_structs.trees.binary.iterators.BSTIterator;


public class Program {

	public static void main(String[] args) {
		BinarySearchTree<Integer, String> st = new BinarySearchTree<>();
		
		st.insert(5, "b");
		st.insert(8, "a");
		st.insert(3, "c");
		st.insert(7, "d");
		st.insert(12, "p");
		st.insert(18, "p");
		st.insert(16, "p");
		st.insert(25, "p");
		st.insert(38, "sa");
		st.insert(84, "k");
		
		@SuppressWarnings("unchecked")
		BSTIterator<Integer, String> it = (BSTIterator<Integer, String>) st.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
