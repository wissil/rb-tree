package filip.custom.data_structs.trees;

public class Program {

	public static void main(String[] args) {
		SearchTree<Integer, String> st = new BinarySearchTree<>();
		
		st.insert(5, "b");
		st.insert(8, "a");
		st.insert(3, "c");
		st.insert(7, "d");
		st.insert(12, "p");
		st.insert(18, "p");
		st.insert(16, "p");
		st.insert(25, "p");
		
		System.out.println(st.getInterval(5, 18));
	}
}
