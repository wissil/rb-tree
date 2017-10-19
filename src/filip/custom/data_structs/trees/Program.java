package filip.custom.data_structs.trees;

import filip.custom.data_structs.trees.binary.BinarySearchTree;


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
		
		System.out.println(st);
				
//		
		System.out.println();
		System.out.println();
		
		System.out.println(st.getInterval(8, 26));
				
	}
}
