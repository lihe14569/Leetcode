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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int size = 0;
        for(ListNode curr = head; curr != null; curr = curr.next) size++;
        if(n == size) return head.next;
        ListNode curr = head;
        for(int i = 0; i < size - n - 1; i++)
            curr = curr.next;
        curr.next =curr.next.next;
        return head;
    }
}