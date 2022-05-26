# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        
        dummy = ListNode(-1)
        dummy.next = head
        curr = dummy
        while curr.next and curr.next.next:
            a, b, c = curr.next, curr.next.next, curr.next.next.next
            curr.next = b
            b.next = a
            a.next = c
            curr = a
        return dummy.next