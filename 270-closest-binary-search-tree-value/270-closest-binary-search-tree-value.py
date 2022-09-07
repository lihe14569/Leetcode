# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def closestValue(self, root: Optional[TreeNode], target: float) -> int:
        inorder_lst = []
        diff = float('inf')
        res = 0
        def inorder(root):
            nonlocal inorder_lst, res, diff
            if not root: return
            inorder(root.left)
            if abs(root.val - target) < diff:
                res = root.val
                diff = abs(root.val - target)
            inorder(root.right)
        inorder(root)
        return res