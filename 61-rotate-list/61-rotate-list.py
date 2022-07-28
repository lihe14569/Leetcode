# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or not head.next: return head
        n = 0
        curr = head 
        while curr:
            curr = curr.next
            n += 1
        k = k % n
        first, second = head, head
        for i in range(k):
            first = first.next
        while first.next:
            first = first.next
            second = second.next
        
        first.next = head
        newHead = second.next
        second.next = None
        return newHead