# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def closestValue(self, root: Optional[TreeNode], target: float) -> int:
        
        stack = []
        diff = float('inf')
        res = 0
        
        while stack or root:
            while root:
                stack.append(root)
                root =root.left
            root = stack.pop()
            if abs(root.val - target) < diff:
                res = root.val
                diff = abs(root.val - target) 
            root = root.right
        return res