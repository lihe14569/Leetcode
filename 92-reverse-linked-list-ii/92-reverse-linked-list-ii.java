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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode a = dummy;
        //需要四个点
        for(int i = 0; i < left -1 ; i++) a = a.next;
        ListNode c = a;
        for(int i = 0; i < right - left + 1; i++) c = c.next;
        ListNode b = a.next, d = c.next;
        
        for(ListNode prev = b, curr = b.next; curr != d;) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        a.next = c;
        b.next = d;

        return dummy.next;
    }
    
}