# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        if not root1:
            return False
        def dfs(root1, root2):
            if not root1 and not root2:
                return True
            if not root1 or not root2:
                return False
            if root1.val != root2.val:
                return False
            return dfs(root1.left, root2.left) and dfs(root1.right, root2.right)
        return dfs(root1, root2) or self.isSubtree(root1.left, root2) or self.isSubtree(root1.right, root2)

        