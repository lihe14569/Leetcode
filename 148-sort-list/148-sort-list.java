/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        //divide and conquer
        if(head == null || head.next == null) return head;
        //divide list in half
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }
    public ListNode merge(ListNode l, ListNode r) {
        if(l == null) return r;
        if(r == null) return l;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(l != null && r != null) {
            if(l.val <= r.val) {
                curr.next = l;
                l = l.next;
            } else {
                curr.next = r;
                r = r.next;
            }
            curr = curr.next;
        }
        if(l != null) curr.next = l;
        if(r != null) curr.next = r;
        return dummy.next;
    }
}