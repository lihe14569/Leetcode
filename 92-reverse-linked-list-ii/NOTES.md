java solution:
```
public ListNode reverseBetween(ListNode head, int left, int right) {
if(head == null || head.next == null) return head;
ListNode dummy = new ListNode(-1);
dummy.next = head;
ListNode a = dummy, c = dummy;
for(int i = 0; i < left - 1; i ++) a = a.next;
for(int i = 0; i < right; i ++) c = c.next;
ListNode b = a.next, d = c.next;
for(ListNode prev = b, curr = b.next; curr != d; ) {
ListNode next = curr.next;
curr.next = prev;
prev = curr;
curr = next;
}
a.next = c;
b.next = d;
return dummy.next; //头节点可能改变，记住用dummy node
}
```