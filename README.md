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

```html
<p>&#9492;&#9472;&#9472; (K:5, V:Joe)  &#9500;&#9472;&#9472; (K:3, V:Jack)  &#9492;&#9472;&#9472; (K:8, V:John)  &#9500;&#9472;&#9472; (K:7, V:Jacob)  &#9492;&#9472;&#9472; (K:12, V:Jim)  &#9492;&#9472;&#9472; (K:18, V:Mary)  &#9500;&#9472;&#9472; (K:16, V:Margareth)  &#9492;&#9472;&#9472; (K:25, V:Miranda)  &#9492;&#9472;&#9472; (K:38, V:Mia)  &#9492;&#9472;&#9472; (K:84, V:Rob)  &#9492;&#9472;&#9472; (K:68, V:Julia)</p>

<p>======================================================== ========================================================</p>

<p>&#9492;&#9472;&#9472; (K:8, V:John)  &#9500;&#9472;&#9472; (K:5, V:Joe)  &#9474; &#9500;&#9472;&#9472; (K:3, V:Jack)  &#9474; &#9492;&#9472;&#9472; (K:7, V:Jacob)  &#9492;&#9472;&#9472; (K:16, V:Margareth)  &#9500;&#9472;&#9472; (K:12, V:Jim)  &#9492;&#9472;&#9472; (K:25, V:Miranda)  &#9500;&#9472;&#9472; (K:18, V:Mary)  &#9492;&#9472;&#9472; (K:68, V:Julia)  &#9500;&#9472;&#9472; (K:38, V:Mia)  &#9492;&#9472;&#9472; (K:84, V:Rob)</p>
```
