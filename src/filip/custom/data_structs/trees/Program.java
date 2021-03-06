package filip.custom.data_structs.trees;

import java.util.LinkedHashMap;
import java.util.Map;

import filip.custom.data_structs.trees.factories.BSTFactory;
import filip.custom.data_structs.trees.factories.RBTFactory;


public class Program {

	public static void main(String[] args) {
		
		Map<Integer, String> entries = new LinkedHashMap<>();
		entries.put(5, "Joe");
		entries.put(8, "John");
		entries.put(3, "Jack");
		entries.put(7, "Jacob");
		entries.put(12, "Jim");
		entries.put(18, "Mary");
		entries.put(16, "Margareth");
		entries.put(25, "Miranda");
		entries.put(38, "Mia");
		entries.put(84, "Rob");
		entries.put(68, "Julia");	
								
		// binary search tree
		SearchTree<Integer, String> bst = SearchTree.createFromMap(entries, new BSTFactory<>());
		SearchTree<Integer, String> rbt = SearchTree.createFromMap(entries, new RBTFactory<>());
						
		System.out.println(bst);
		System.out.println("========================================================\n");
		System.out.println(rbt);
	}
}
