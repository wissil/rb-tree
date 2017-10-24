# rb-tree

Custom implementation of a Red-Black Tree based on a Binary Search Tree.

```java
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

// red-black tree
SearchTree<Integer, String> rbt = SearchTree.createFromMap(entries, new RBTFactory<>());
						
System.out.println(bst);
System.out.println("========================================================\n");
System.out.println(rbt);
```
... outputs

```text
└── (5, Joe)
    ├── (3, Jack)
    └── (8, John)
        ├── (7, Jacob)
        └── (12, Jim)
            └── (18, Mary)
                ├── (16, Margareth)
                └── (25, Miranda)
                    └── (38, Mia)
                        └── (84, Rob)
                            └── (68, Julia)

========================================================

└── (8, John)
    ├── (5, Joe)
    │   ├── (3, Jack)
    │   └── (7, Jacob)
    └── (16, Margareth)
        ├── (12, Jim)
        └── (25, Miranda)
            ├── (18, Mary)
            └── (68, Julia)
                ├── (38, Mia)
                └── (84, Rob)
```
