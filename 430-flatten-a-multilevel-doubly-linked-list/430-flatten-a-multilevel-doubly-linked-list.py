"""
# Definition for a Node.
class Node:
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child
"""

class Solution:
    def flatten(self, head: 'Optional[Node]') -> 'Optional[Node]':
        #recursive
        if not head:
            return head
        dummy = Node(0, None, head, None)
        dummy.next = head
        self.flattenTree(dummy, head)
        #break the pointer with dummy node
        dummy.next.prev = None
        return dummy.next
        
    def flattenTree(self, prev, curr):
        if not curr:
            return prev
        curr.prev = prev
        prev.next = curr
        
        next = curr.next
        tail = self.flattenTree(curr, curr.child)
        curr.child = None
        return self.flattenTree(tail, next)