bottom-up iterative method  time nlogn, space o1
方法一：暴力解
```
public ListNode sortList(ListNode head) {
List<Integer> lst = new ArrayList<>();
for(ListNode curr = head; curr != null; curr = curr.next) {
lst.add(curr.val);
}
Collections.sort(lst);
int i = 0;
for(ListNode curr = head; curr != null; curr = curr.next) {
curr.val = lst.get(i++);
}
return head;
}
```
​
​
​
```
public ListNode sortList(ListNode head) {
//bottom up
if(head == null || head.next == null) return head;
ListNode dummy = new ListNode(-1);
dummy.next = head;
//get list length
int n = 0;
for(ListNode p = head; p != null; p =p.next) n++;
for(int i = 1; i < n; i*= 2) {
ListNode curr = dummy;
for(int j = 0; j + i < n; j += 2 * i) {
ListNode first = curr.next, second = first;
for(int k = 0; k < i; k++) second = second.next;
//merge sort two part
int f = 0, s = 0;
while(f < i && s < i && second != null) {
if(first.val < second.val) {
curr.next = first;
first = first.next;
curr = curr.next;
f++;
} else {
curr.next = second;