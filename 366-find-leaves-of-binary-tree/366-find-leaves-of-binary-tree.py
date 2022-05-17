# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        
        if not root:
            return []
        result=[]
        while root:
            curLeaves = []
            root = self._findLeaves(root, curLeaves)
            
            result.append(curLeaves)
        
        return result 

    def _findLeaves(self, root, curLeaves):
        if not root:
            return None
        if not root.left and not root.right:
            curLeaves.append(root.val)
            return None
        else:
            root.left = self._findLeaves(root.left, curLeaves)
            root.right = self._findLeaves(root.right, curLeaves)
            return root