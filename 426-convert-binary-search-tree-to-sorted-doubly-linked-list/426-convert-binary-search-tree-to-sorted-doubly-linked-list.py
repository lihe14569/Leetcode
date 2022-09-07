"""
# Definition for a Node.
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
"""

class Solution:
    def treeToDoublyList(self, root: 'Optional[Node]') -> 'Optional[Node]':
        head, tail = None, None
        if not root: return root
        def inorder(root):
            nonlocal head,tail
            if not root:
                return
            inorder(root.left)
            if not head:
                head = root
            else:
                tail.right = root
                root.left = tail
            tail = root
            inorder(root.right)
        inorder(root)
        head.left = tail
        tail.right = head
        return head