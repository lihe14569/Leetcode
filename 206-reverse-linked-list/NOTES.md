method1: recursive solution
```
def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
#recursive
if not head or not head.next:
return head
next = head.next
new_head = self.reverseList(head.next)
next.next = head
head.next = None
return new_head
```
​
method2: iterative
​