public boolean hasNext() {
return pointer < n - 1;
}
public int next() {
return list.get(++pointer);
}
public boolean hasPrev() {
return pointer > 0;
}
public int prev() {
return list.get(--pointer);
}
}
​
/**
* Your BSTIterator object will be instantiated and called as such:
* BSTIterator obj = new BSTIterator(root);
* boolean param_1 = obj.hasNext();
* int param_2 = obj.next();
* boolean param_3 = obj.hasPrev();
* int param_4 = obj.prev();
*/
```
​
Approach 2: Follow-up: Iterative Inorder Traversal
​
```
​
```
​