# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        cache = {}
        def dfs(root):
            nonlocal cache
            if not root:
                return 0 
            if root in cache:
                return cache[root]
            sum = 0
            sum += root.val
            left = dfs(root.left)
            right = dfs(root.right)
            if root.left:
                sum += dfs(root.left.left) + dfs(root.left.right)
            if root.right:
                sum += dfs(root.right.left) + dfs(root.right.right)
            
            cache[root] = max(sum, left + right)
            return cache[root]
            
        return max(dfs(root), dfs(root.left) + dfs(root.right))
            