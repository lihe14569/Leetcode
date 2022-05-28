方法一： recursive method
```
def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
if not root or root == p or root == q:
return root
left = self.lowestCommonAncestor(root.left, p, q)
right = self.lowestCommonAncestor(root.right, p, q)
if left and right: return root
else: return left or right
```
​
方法二： iterative in java
```
class Solution {
Map<TreeNode, TreeNode> map = new HashMap<>();
Set<TreeNode> visited = new HashSet<>();
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
if(root == null || root == p || root == q) return root;
dfs(root);
while(p != null) {
visited.add(p);
p = map.get(p);
}
while(q != null) {