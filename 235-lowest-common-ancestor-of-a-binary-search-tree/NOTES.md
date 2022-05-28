方法一：iterative
```
def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
while True:
if root.val > p.val and root.val > q.val:
root = root.left
elif root.val <p.val and root.val < q.val:
root= root.right
else:
return root
```
方法二：recursion
```
def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
#recursion
if not root or root == p or root == q:
return root
if p.val > root.val and q.val > root.val:
return self.lowestCommonAncestor(root.right, p, q)
if p.val < root.val and q.val < root.val:
return self.lowestCommonAncestor(root.left, p, q)
return root
```
​
​