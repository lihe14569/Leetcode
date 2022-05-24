method1: mid point + reverse the list
```
class Solution:
def isPalindrome(self, head: Optional[ListNode]) -> bool:
#find mid point of the list, reverse list  and compare
fast = slow = head
while fast and fast.next:
fast = fast.next.next
slow =slow.next
#for odd number nodes,move 1 step right from mid point
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
#since length of right half list is not greater than left half
while fast:
if fast.val != slow.val:
return False
fast = fast.next
slow =slow.next
return True
```