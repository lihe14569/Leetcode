# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        max_freq = 0
        dic = {}
        def inorder(root):
            nonlocal res, max_freq, dic
            if not root:
                return 
            inorder(root.left)
            if root.val not in dic:
                dic[root.val] = 1
            else:
                dic[root.val] += 1
            if dic[root.val] > max_freq:
                max_freq = dic[root.val]
                res.clear()
                res.append(root.val)
            elif dic[root.val] == max_freq:
                res.append(root.val)
            inorder(root.right)
        inorder(root)
        return res