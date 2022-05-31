if not root or root == p or root == q:
visited.add(p);
p = map.get(p);
}
while(q != null) {
if(visited.contains(q))
return q;
q = map.get(q);
}
return null;
}
public void dfs(TreeNode root) {
if(root == null) return;
if(root.left != null) {
map.put(root.left, root);
dfs(root.left);
}
if(root.right != null) {
map.put(root.right, root);
dfs(root.right);
}
}
}
```
​
iterative python version
```
def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
parent = {}
parent[root] = None
def dfs(root):
nonlocal parent
if not root:
return
if root.left:
parent[root.left] = root
dfs(root.left)
if root.right:
parent[root.right] = root
dfs(root.right)
dfs(root)
seen = set()
while p:
seen.add(p)
p = parent[p]
while q:
if q in seen:
return q
q = parent[q]
return root
```