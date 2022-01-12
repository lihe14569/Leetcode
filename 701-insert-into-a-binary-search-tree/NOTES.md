方法一：recursive method
```
public TreeNode insertIntoBST(TreeNode root, int val) {
//recursive
if(root == null) {
root = new TreeNode(val);
return root;
}
if(val > root.val) root.right = insertIntoBST(root.right, val);
else root.left = insertIntoBST(root.left, val);
return root;
}
```
​
方法二： iterative method
​
```
​
```