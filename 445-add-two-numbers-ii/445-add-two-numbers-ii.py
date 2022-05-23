# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        s1, s2 = [], []
        
        while l1:
            s1.append(l1.val)
            l1 = l1.next
            
        while l2:
            s2.append(l2.val)
            l2 = l2.next
        dummy = ListNode(0)
        dummy.next = None
        carry = 0
        while s1 or s2:
            val1 = s1.pop() if s1 else 0
            val2 = s2.pop() if s2 else 0
            sum = val1 + val2 + carry
            node = ListNode(sum % 10)
            carry = sum // 10
            node.next = dummy.next
            dummy.next = node
        if carry == 1:
            node = ListNode(1)
            node.next = dummy.next
            dummy.next = node
        return dummy.next