package filip.custom.data_structs.trees;

import filip.custom.data_structs.trees.binary.BinarySearchTree;
import filip.custom.data_structs.trees.binary.traversal.InOrderBSTreeTraversal;
import filip.custom.data_structs.trees.binary.traversal.PostOrderBSTreeTraversal;
import filip.custom.data_structs.trees.binary.traversal.PreOrderBSTreeTraversal;
import filip.custom.data_structs.trees.traversal.SearchTreeTraversal;
import filip.custom.data_structs.trees.traversal.visitors.CollectNodeVisitor;
import filip.custom.data_structs.trees.traversal.visitors.PrintNodeVisitor;
import filip.custom.data_structs.trees.traversal.visitors.SearchTreeNodeVisitor;

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
		
		SearchTreeNodeVisitor<Integer, String> printVisitor = new PrintNodeVisitor<>();
		
		CollectNodeVisitor<Integer, String> collectVisitor = new CollectNodeVisitor<>();
		
		SearchTreeTraversal<Integer, String, BinarySearchTree<Integer, String>> inorder = 
				new InOrderBSTreeTraversal<>();
		
		SearchTreeTraversal<Integer, String, BinarySearchTree<Integer, String>> preorder = 
				new PreOrderBSTreeTraversal<>();
		
		SearchTreeTraversal<Integer, String, BinarySearchTree<Integer, String>> postorder = 
				new PostOrderBSTreeTraversal<>();
		
		inorder.traverse((BinarySearchTree<Integer, String>) st, collectVisitor);
		
		System.out.println(String.join("-->", collectVisitor.getNodes()));
	}
}
