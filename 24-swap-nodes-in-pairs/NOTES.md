画图表示a,b,c，简单明了
​
```
public ListNode swapPairs(ListNode head) {
if(head == null || head.next == null) return head;
ListNode dummy = new ListNode();
dummy.next = head;
ListNode curr = dummy;
while(curr.next != null && curr.next.next != null) {
ListNode a = curr.next, b = a.next, c = b.next;
curr.next = b;
b.next = a;
a.next = c;
curr = a;
}
return dummy.next;
}
```