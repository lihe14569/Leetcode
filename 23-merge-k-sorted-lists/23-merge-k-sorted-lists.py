# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        ListNode.__lt__ =lambda self, other: self.val < other.val
        dummy = curr =ListNode(0)
        pq = []
        for node in lists:
            if node:
                heapq.heappush(pq, node)
        
        while pq:
            node = heapq.heappop(pq)
            curr.next = node
            curr =curr.next
            if node.next:
                heapq.heappush(pq, node.next)
        return dummy.next