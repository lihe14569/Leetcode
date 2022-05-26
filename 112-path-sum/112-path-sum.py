# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if not root:
            return False
        sum = 0
        def dfs(root, sum):
            if not root:
                return False
            if not root.left and not root.right:
                return sum + root.val == targetSum
            
            return dfs(root.left, sum + root.val) or dfs(root.right, sum + root.val)
        return dfs(root, 0)