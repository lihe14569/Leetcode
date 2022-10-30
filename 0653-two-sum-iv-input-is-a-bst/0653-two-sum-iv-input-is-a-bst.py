# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        lst = []
        def inorder(root):
            nonlocal lst
            if not root:
                return
            inorder(root.left)
            lst.append(root.val)
            inorder(root.right)
        inorder(root)
        l, r = 0, len(lst) - 1
        while l < r:
            sum = lst[l] + lst[r]
            if sum == k:
                return True
            elif sum < k:
                l += 1
            else:
                r -= 1
        return False