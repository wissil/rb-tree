# rb-tree

Custom implementation of a Red-Black Tree based on a Binary Search Tree.

Example usage ...

```java
Map<Integer, String> entries = new HashMap<>();
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
SearchTree<Integer, String> bst =
            new BSTFactory<Integer, String>().createFromMap(entries);

// red black tree
SearchTree<Integer, String> rbt =
            new RBTFactory<Integer, String>().createFromMap(entries);

System.out.println(bst);
System.out.println("========================================================\n");
System.out.println(rbt);
```
... outputs

```text
└── (K:5, V:Joe)
    ├── (K:3, V:Jack)
    └── (K:8, V:John)
        ├── (K:7, V:Jacob)
        └── (K:12, V:Jim)
            └── (K:18, V:Mary)
                ├── (K:16, V:Margareth)
                └── (K:25, V:Miranda)
                    └── (K:38, V:Mia)
                        └── (K:84, V:Rob)
                            └── (K:68, V:Julia)

========================================================

└── (K:8, V:John)
    ├── (K:5, V:Joe)
    │   ├── (K:3, V:Jack)
    │   └── (K:7, V:Jacob)
    └── (K:16, V:Margareth)
        ├── (K:12, V:Jim)
        └── (K:25, V:Miranda)
            ├── (K:18, V:Mary)
            └── (K:68, V:Julia)
                ├── (K:38, V:Mia)
                └── (K:84, V:Rob)
```
