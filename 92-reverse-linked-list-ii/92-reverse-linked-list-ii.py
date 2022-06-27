# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        if not head or not head.next: return head
        dummy = ListNode(-1)
        dummy.next = head
        a = c = dummy
        for i in range(left - 1):
            a = a.next
        for i in range(right):
            c = c.next
        b = a.next
        d = c.next
        prev, curr = b, b.next
        while curr != d:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        a.next = c
        b.next = d
        return dummy.next
        