# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def longestUnivaluePath(self, root: Optional[TreeNode]) -> int:
        res = 0
        def dfs(root):
            nonlocal res
            if not root:
                return 0
            left = dfs(root.left) 
            right = dfs(root.right) 
            pl = pr = 0
            if root.left and root.val == root.left.val:
                pl = left + 1
            if root.right and root.val == root.right.val:
                pr = right + 1
            res = max(res, pl + pr)
            return max(pl, pr)
        dfs(root)
        return res