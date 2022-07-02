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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = dummy.next;
        while(curr != null && curr.next != null) {
            ListNode a = curr, b = a.next, c = b.next;
            prev.next = b;
            b.next = a;
            a.next = c;
            
            prev = a;
            curr = c;
        }
        return dummy.next;
    }
}