labuladong解法 recursive + global found boolean variable
```
def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
foundP = foundQ = False
def LCA(root):
nonlocal foundP, foundQ
if not root:
return None
left = LCA(root.left)
right = LCA(root.right)
#marked found p or q
if root == p or root == q:
if root == p:
foundP = True
if root == q:
foundQ = True
return root
#case1
if left and right:
return root
if not left and not right:
return None
return left or right
res = LCA(root)
if foundP and foundQ:
return res
return None
```