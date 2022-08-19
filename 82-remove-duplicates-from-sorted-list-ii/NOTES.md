注意while loop里面if的判断
```
class Solution {
public ListNode deleteDuplicates(ListNode head) {
if(head == null || head.next == null) return head;
ListNode dummy = new ListNode(-1);
dummy.next = head;
ListNode prev = dummy, curr = dummy.next;
while(curr != null ) {
if(curr.next != null && curr.val == curr.next.val) {
while(curr.next != null && curr.val == curr.next.val)
curr = curr.next;
prev.next = curr.next;
} else {
prev = prev.next;
}
curr =curr.next;
}
return dummy.next;
}
}
```