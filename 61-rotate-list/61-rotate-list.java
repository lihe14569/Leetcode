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
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null) return head;
        int size = 0;
        for(ListNode curr = head; curr != null; curr = curr.next) size++;
        k %= size;
        ListNode f = head, s = head;
        for(int i = 0; i < k; i++) f = f.next;
        while(f.next != null) {
            f = f.next;
            s = s.next;
        }
        f.next = head; 
        head = s.next;
        s.next = null;
        return head;
        
    }
}