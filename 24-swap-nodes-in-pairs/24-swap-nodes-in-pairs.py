# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(-1)
        dummy.next=  head
        curr = dummy
        if not head: return head
        
        while curr.next and curr.next.next:
            a, b , c = curr.next, curr.next.next, curr.next.next.next
            curr.next = b
            b.next = a
            a.next = c
            curr = a
        return dummy.next
            
        