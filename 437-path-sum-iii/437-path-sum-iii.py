# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        #recursion
        def dfs(root, sum):
            step = 0
            if not root:
                return 0
            if root.val == sum:
                step += 1
            step += dfs(root.left, sum - root.val) + dfs(root.right, sum - root.val)
            return step
        if not root:
            return 0
        return dfs(root, targetSum) + self.pathSum(root.left, targetSum) + self.pathSum(root.right, targetSum)
        