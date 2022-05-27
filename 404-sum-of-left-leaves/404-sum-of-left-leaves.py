# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        
        def dfs(root):
            #base case
            if not root:
                return 0
            #recurrence
            curr_sum = 0
            def isLeaf(node):
                if not node:
                    return False
                if not node.left and not node.right:
                    return True
            if isLeaf(root.left):
                curr_sum += root.left.val
            left = dfs(root.left)
            right =dfs(root.right)
            return curr_sum + left + right
        return dfs(root)
        