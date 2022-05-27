# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        #recursion
        #function: get the number of path start from root
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
        #answer is composed three part:
        #1. root as start point included
        #2. root.left as start point, included
        #3. root.right as start point, included
        
        return dfs(root, targetSum) + self.pathSum(root.left, targetSum) + self.pathSum(root.right, targetSum)
        