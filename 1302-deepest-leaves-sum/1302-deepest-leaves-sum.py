# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def deepestLeavesSum(self, root: Optional[TreeNode]) -> int:
        lsum, maxDepth = 0, 0
        def dfs(root, depth):
            if not root: return depth - 1
            if not root.left and not root.right:
                return depth
            left = dfs(root.left, depth + 1)
            right =dfs(root.right, depth + 1)
            return max(left, right)
        
        maxDepth= dfs(root, 0)
        
        def dfs2(root, depth):
            nonlocal maxDepth,lsum
            if depth == maxDepth:
                lsum += root.val
            if root.left:
                dfs2(root.left, depth + 1)
            if root.right:
                dfs2(root.right, depth + 1)
        dfs2(root, 0)
        return lsum