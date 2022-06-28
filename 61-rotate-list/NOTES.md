two pointers
```
public ListNode rotateRight(ListNode head, int k) {
if(head == null) return head;
int size = 0;
for(ListNode curr = head; curr != null; curr= curr.next) size++;
k  %= size;
ListNode first = head,second = head;
for(int i = 0; i < k; i++) first = first.next;
while(first.next != null) {
first = first.next;
second = second.next;
}
first.next = head;
head = second.next;
second.next = null;
return head;
}
```