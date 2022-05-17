# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findLeaves(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        res = []
        while root:
            curr_level = []
            root = self.dfs(root, curr_level)
            res.append(curr_level)
        return res
    def dfs(self,root, level):
        if not root:
            return None
        if not root.left and not root.right:
            level.append(root.val)
            return None
        else:
            root.left = self.dfs(root.left, level)
            root.right = self.dfs(root.right, level)
            return root