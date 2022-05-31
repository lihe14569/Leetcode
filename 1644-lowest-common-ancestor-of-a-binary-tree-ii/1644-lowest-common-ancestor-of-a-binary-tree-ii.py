# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        parent ={}
        parent[root] = None
        def dfs(root):
            nonlocal parent
            if not root:
                return 
            if root.left:
                parent[root.left] =root
                dfs(root.left)
            if root.right:
                parent[root.right] = root
                dfs(root.right)
        dfs(root)
        if not root or p not in parent or q not in parent:
            return None
        seen = set()
        while p:
            seen.add(p)
            p = parent[p]
        while q:
            if q in seen:
                return q
            q = parent[q]
        