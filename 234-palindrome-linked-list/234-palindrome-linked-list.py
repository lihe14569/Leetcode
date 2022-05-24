# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        p1 = head
        def recursive(p2):
            nonlocal p1
            if not p2:
                return True
            else:
                if not recursive(p2.next):
                    return False
                if p1.val != p2.val:
                    return False
                p1 = p1.next
                return True
        return recursive(head)
            