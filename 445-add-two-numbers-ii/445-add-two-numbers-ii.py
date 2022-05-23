# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        
        
        s1,s2=0,0
        
        while l1!=None:
            s1=s1*10+l1.val
            l1=l1.next
        
        while l2!=None:
            s2=s2*10+l2.val
            l2=l2.next
        
        sum = s1 + s2
        if sum == 0:
            return ListNode(0)
        dummylist=dummy=ListNode(0)
        dummy.next = None
        while sum > 0:
            val = sum%10
            sum //= 10
            node= ListNode(val)
            node.next = dummy.next
            dummy.next = node
        
        
        return dummylist.next