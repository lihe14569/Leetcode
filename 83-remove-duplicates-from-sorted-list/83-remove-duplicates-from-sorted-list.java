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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, curr = dummy.next;
        
        while(curr != null) {
            //remove the duplicate
            if(curr.next != null && curr.val == curr.next.val) {
                curr.next = curr.next.next;
                continue;
            }
            //move forward
            prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}