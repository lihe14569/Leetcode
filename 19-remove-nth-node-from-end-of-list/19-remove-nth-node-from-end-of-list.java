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
        //o(n)
        int size = 0;
        for(ListNode curr = head; curr != null; curr = curr.next)  size++;
        if(size == n) return head.next;
        n = size - n;
        
        ListNode curr = head;
        for(int i = 0; i < n - 1; i++) curr = curr.next;
        curr.next = curr.next.next;
        return head;
    }
}