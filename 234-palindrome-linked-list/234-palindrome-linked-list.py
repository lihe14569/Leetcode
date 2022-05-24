# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        #find mid point of the list, reverse list  and compare
        fast = slow = head
        while fast and fast.next:
            fast = fast.next.next
            slow =slow.next
        if fast: slow = slow.next
        def reverse(head):
            prev, curr = None, head
            while curr:
                next = curr.next
                curr.next = prev
                prev = curr
                curr = next
            return prev
        fast = reverse(slow)
        slow = head
        while fast:
            if fast.val != slow.val:
                return False
            fast = fast.next
            slow =slow.next
        return True
            