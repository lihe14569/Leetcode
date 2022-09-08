solution
```
class BSTIterator {
Deque<TreeNode> stack;
TreeNode root;
public BSTIterator(TreeNode root) {
this.root = root;
stack = new ArrayDeque<>();
}
public int next() {
while(root!= null) {
stack.push(root);
root = root.left;
}
root = stack.pop();
int res = root.val;
root = root.right;
return res;
}
public boolean hasNext() {
// while(root != null) {
//     stack.push(root);
//     root = root.left;
// }