# rb-tree

Custom implementation of a Red-Black Tree based on a Binary Search Tree.

Example usage ...

```java
List<SearchTree.Entry<Integer, String>> lst =
    Arrays.asList((TreeEntry<Integer, String>[]) new TreeEntry[] {
        new TreeEntry(5, "Joe"),
        new TreeEntry(8, "John"),
        new TreeEntry(3, "Jack"),
        new TreeEntry(7, "Jacob"),
        new TreeEntry(12, "Jim"),
        new TreeEntry(18, "Mary"),
        new TreeEntry(16, "Margareth"),
        new TreeEntry(25, "Miranda"),
        new TreeEntry(38, "Mia"),
        new TreeEntry(84, "Rob"),
        new TreeEntry(68, "Julia")
    });

// binary search tree
SearchTree<Integer, String> bst = new BSTFactory().createFromList(lst);

// red black tree
SearchTree<Integer, String> rbt = new RBTFactory().createFromList(lst);
```
