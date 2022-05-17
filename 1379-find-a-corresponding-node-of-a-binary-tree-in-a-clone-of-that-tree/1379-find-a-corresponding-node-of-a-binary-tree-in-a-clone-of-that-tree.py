# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def getTargetCopy(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:
        def dfs(root):
            if target.val == root.val:
                return root
            res, left, right = TreeNode(-1), None, None
            if root.left:
                left = dfs(root.left)
            if root.right:
                right = dfs(root.right)
            return left or right
        return dfs(cloned)
        