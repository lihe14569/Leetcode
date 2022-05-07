method1: pq
```
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
```
​
method2: merge-sort
```
​
```