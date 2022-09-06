solution
```
class Solution {
double diff = Double.MAX_VALUE;
int res;
public int closestValue(TreeNode root, double target) {
inorder(root, target);
return res;
}
public void inorder(TreeNode root, double target) {
if(root == null) return;
if(Math.abs(root.val - target) < diff) {
diff = Math.abs(root.val - target);
res = root.val;
}
if(root.val < target) inorder(root.right, target);
else inorder(root.left, target);
}
}
```