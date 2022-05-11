"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        lst = []
        def dfs(root, lst):
            if root is None:
                return
            lst.append(root.val)
            for node in root.children:
                dfs(node, lst)
        dfs(root, lst)
        return lst