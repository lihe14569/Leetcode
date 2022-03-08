/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // public boolean hasCycle(ListNode head) {
    //     if(head == null || heade.next == null) return false;
    //     ListNode slow = head, fast = head;
    //     slow = slow.next;
    //     fast = fast.next.next;
    //     while(fast != slow) {
    //         slow = slow.next;
    //         fast = fasst.next.next;
    //     }
    //     slow = head;
    //     while(fast != slow) {
    //         slow = slow.next;
    //         fast = fast.next;
    //     }
    //     return fast;
    //     //----------
    //     //       |   \
    //     //      |     \
    //     //      \ _ c_ / 
    //     //       
    //     // 2(f + a) = f + a + nC
    //     // F+ a = nC
    //     //
    // }
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}