# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        if not root: return 0
        
        def dfs(root, currMax):
            
            if not root: return 0
            cnt = 0
            if root.val >= currMax:
                cnt += 1
                currMax = root.val
            cnt += dfs(root.left,currMax)
            cnt += dfs(root.right, currMax)
            return cnt
        return dfs(root, root.val)