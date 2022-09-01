# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def longestConsecutive(self, root: Optional[TreeNode]) -> int:
        len = 0
        def dfs(root):
            nonlocal len
            if not root: return 0
            
            curr = 1
            if root.left:
                if root.val  + 1 == root.left.val:
                    curr = max(curr, 1 + dfs(root.left))
                else:
                    dfs(root.left)
            if root.right:
                if root.val + 1 == root.right.val:
                    curr = max(curr, 1 + dfs(root.right))
                else:
                    dfs(root.right)
            len = max(len, curr)
            return curr
        dfs(root)
        return len