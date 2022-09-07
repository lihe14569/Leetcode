# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if not root: return True
        def valid(root, min, max):
            if not root: return True
            if root.val <= min or root.val >= max:
                return False
            return valid(root.left, min, root.val) and valid(root.right, root.val, max)
        return valid(root, float('-inf'), float('inf'))