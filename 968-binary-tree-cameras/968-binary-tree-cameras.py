# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minCameraCover(self, root: Optional[TreeNode]) -> int:
        # 0: cannot covered
        #1: placed camera
        #2: covered
        cnt = 0
        def dfs(root):
            nonlocal cnt
            if not root:
                return 2
            left, right= dfs(root.left), dfs(root.right)
            if left == 0 or right == 0:
                cnt += 1
                return 1
            if left == 2 and right == 2:
                return 0
            else:
                return 2
        if dfs(root) == 0:
            cnt += 1
        
        return cnt
        