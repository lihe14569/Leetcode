# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or not head.next: return head
        dummy = ListNode(-1)
        dummy.next = head
        prev, curr = dummy, dummy.next
        
        while curr:
            tail = prev
            
            for i in range(k):
                if not tail:
                    break
                tail = tail.next
            if not tail: break
            next = tail.next
            def reverse(head, tail):
                nextHead = tail.next
                prev, curr = head, head.next
                while curr != nextHead:
                    next = curr.next
                    curr.next = prev
                    prev = curr
                    curr = next
                return tail, head
            curr, tail = reverse(curr, tail)
            prev.next = curr
            tail.next = next
            prev = tail
            curr = next
        return dummy.next