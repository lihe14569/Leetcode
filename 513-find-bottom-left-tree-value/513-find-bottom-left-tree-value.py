# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:
        q = deque([root])
        leftMost = 0
        while q:
            size = len(q)
            for i in range(size):
                root = q.popleft()
                if i == 0:
                    leftMost = root.val
                if root.left:
                    q.append(root.left)
                if root.right:
                    q.append(root.right)
        return leftMost
            