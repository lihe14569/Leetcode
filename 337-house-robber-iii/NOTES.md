method1 : top-down -> recursion + memo
```
class Solution {
//top-down recursion + memo
Map<TreeNode, Integer> memo = new HashMap<>();
public int rob(TreeNode root) {
//base case
if(root == null) return 0;
//check memo
if(memo.containsKey(root)) return memo.get(root);
int rob = root.val;
if(root.left != null) rob += rob(root.left.left) + rob(root.left.right);
if(root.right != null) rob += rob(root.right.left) + rob(root.right.right);
int not_rob = rob(root.left) + rob(root.right);
int res = Math.max(rob, not_rob);
memo.put(root, res);
return res;
}
}
```
​
method2 : 每个node记录两个状态减少子问题的重复计算
```
class Solution {
public int rob(TreeNode root) {