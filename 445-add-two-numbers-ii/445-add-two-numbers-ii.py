# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        s1, s2= [], []
        
        while l1:
            s1.append(l1.val)
            l1 = l1.next
        while l2:
            s2.append(l2.val)
            l2 = l2.next
            
        carry = 0
        dummy = ListNode(-1)
        dummy.next = None
        
        while s1 or s2:
            val1 = s1.pop() if s1 else 0
            val2 = s2.pop() if s2 else 0
            sum = val1 + val2 +carry
            node = ListNode(sum % 10)
            carry = sum // 10
            node.next = dummy.next
            dummy.next = node
        if carry:
            node= ListNode(carry)
            node.next = dummy.next
            dummy.next = node
        return dummy.next