java
```
public ListNode reverseKGroup(ListNode head, int k) {
if(head == null || head.next == null) return head;
//create dummy node
ListNode dummy = new ListNode(-1);
dummy.next = head;
ListNode prev = dummy, curr = dummy.next;
while(curr != null) {
//find the partial reverse tail
ListNode tail = prev;
for(int i = 0; i < k && tail != null; i++) tail = tail.next;
if(tail == null) break;
//store tail next node
ListNode next = tail.next;
//reverse the partial list
ListNode[] rev = reverse(curr, tail);
curr = rev[0];
tail = rev[1];
//connect head, tail back the list
prev.next = curr;
tail.next = next;
//update the prev and curr
prev = tail;
curr = next;
}
return dummy.next;
}
public ListNode[] reverse(ListNode head, ListNode tail) {
//定义截止的node
ListNode nextHead = tail.next;
for(ListNode prev = head, curr = head.next; curr != nextHead; ) {
ListNode next = curr.next;
curr.next = prev;
prev = curr;
curr = next;
}
//返回reverse 之后的 head 和tail，即 head,tail对调
return new ListNode[]{tail, head};
}
}
```