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
    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(-1);
        ListNode after = new ListNode(-1);
        
        ListNode pa = before, pb = after;
        ListNode curr = head;
        while(curr != null) {
            if(curr.val < x) {
                pa.next = curr;
                pa = curr;
            } else {
                pb.next = curr;
                pb = curr;
            }
            curr = curr.next;
        }
        pa.next = after.next;
        pb.next = null;
        return before.next;
    }
}