# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getDirections(self, root: Optional[TreeNode], startValue: int, destValue: int) -> str:
        def lca(root):
            if not root or root.val in (startValue, destValue):
                return root
            left, right = lca(root.left), lca(root.right)
            if left and right:
                return root
            else:
                return left or right
        root = lca(root)
        stack = []
        stack.append((root, ''))
        ps, pd = '', ''
        while stack:
            node, path = stack.pop()
            if node.val == startValue: ps = path
            if node.val == destValue: pd = path
            if node.left:
                stack.append((node.left, path + 'L'))
            if node.right:
                stack.append((node.right, path + 'R'))
        return len(ps)*'U' + pd