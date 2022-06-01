# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        prev = None
        diff = sys.maxsize
        def dfs(root):
            nonlocal prev, diff
            if not root:
                return
            dfs(root.left)
            if prev:
                diff = min(diff, abs(root.val - prev.val))
            prev = root
            dfs(root.right)
        dfs(root)
        return diff
            