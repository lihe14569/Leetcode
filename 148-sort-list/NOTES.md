slow = slow.next;
fast = fast.next.next;
}
//store the mid node
ListNode mid = slow.next;
//split the list from mid
slow.next = null;
return mid;
}
public ListNode merge(ListNode l1, ListNode l2) {
if(l1 == null) return l2;
if(l2 == null) return l1;
ListNode dummy = new ListNode(-1);
ListNode curr = dummy;
while(l1 != null && l2 != null) {
if(l1.val <= l2.val) {
curr.next = l1;
l1 = l1.next;
curr = curr.next;
} else {
curr.next = l2;
l2 = l2.next;
curr =curr.next;
}
}
curr.next = (l1 != null) ? l1 : l2;
return dummy.next;
}
}
```