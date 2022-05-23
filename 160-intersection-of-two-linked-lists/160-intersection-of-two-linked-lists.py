# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if headA == headB:
            return headA
        a, b = headA, headB
        while a.next or b.next:
            a = a.next if a.next else headB
            b = b.next if b.next else headA
            if a == b:
                return a
        return None
        