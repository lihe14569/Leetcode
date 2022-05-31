# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', nodes: 'List[TreeNode]') -> 'TreeNode':
        targets = set()
        for node in nodes:
            targets.add(node)
        def dfs(root):
            if not root:
                return None
            if root in targets:
                return root
            left = dfs(root.left)
            right = dfs(root.right)
            if left and right:
                return root
            if not left and not right:
                return None
            return left or right
        return dfs(root)