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
    //recursive method
    // public ListNode reverseList(ListNode head) {
    //     if(head == null || head.next == null) return head;
    //     ListNode newHead = reverseList(head.next);
    //     head.next.next = head;
    //     head.next =null;
    //     return newHead;
    // }
    //iterative method
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null, curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev =  curr;
            curr = next;
        }
        return prev;
    }
}