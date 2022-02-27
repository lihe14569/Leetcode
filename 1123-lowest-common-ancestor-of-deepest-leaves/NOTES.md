方法一： 求高度，返回高度高的LCA， 求height一遍是o(n),要分别求O(N)遍
```
class Solution {
public TreeNode lcaDeepestLeaves(TreeNode root) {
//O(n^2)
if(root == null) return null;
int l = height(root.left);
int r = height(root.right);
if(l == r) return root;
else if(l > r) return lcaDeepestLeaves(root.left);
else return lcaDeepestLeaves(root.right);
}
//get the height of current node
public int height(TreeNode root) {
if(root == null) return 0;
return 1 + Math.max(height(root.left), height(root.right));
}
}
```
​
方法二：自定义pair 是node 和height的信息或者记录高度
​