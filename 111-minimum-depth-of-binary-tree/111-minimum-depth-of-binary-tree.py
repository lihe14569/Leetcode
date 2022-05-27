# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        def dfs(root, depth):
            if not root.left and not root.right:
                return depth
            left = dfs(root.left, depth + 1) if root.left else sys.maxsize
            right = dfs(root.right, depth + 1) if root.right else sys.maxsize
            return min(left, right)
        return dfs(root, 1)
                
            