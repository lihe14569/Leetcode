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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = slow.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast= fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        fast = reverse(mid);
        slow = head;
        while(fast != null) {
            if(fast.val != slow.val)
                return false;
            slow = slow.next;
            fast= fast.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next =  head.next;
        ListNode newHead = reverse(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
}