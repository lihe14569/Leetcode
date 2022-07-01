# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeZeroSumSublists(self, head: Optional[ListNode]) -> Optional[ListNode]:
        map = {}
        dummy = ListNode(0)
        dummy.next = head
        curr = dummy
        prefix = 0
        while curr:
            prefix += curr.val
            map[prefix] = curr
            curr = curr.next
        
        prefix = 0
        curr = dummy
        while curr:
            prefix += curr.val
            
            curr.next = map[prefix].next
            
            curr = curr.next
        return dummy.next