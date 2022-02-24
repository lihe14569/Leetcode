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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = split(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }
    
    public ListNode split(ListNode head) {
        //split list into half at mid point using two pointer method
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }
    
    public ListNode merge(ListNode left, ListNode right) {
        //merge two sorted list and return the merged head
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(left != null && right != null) {
            if(left.val <= right.val) {
                curr.next = left;
                left = left.next;
                curr = curr.next;
            } else {
                curr.next = right;
                right = right.next;
                curr =curr.next;
            }
        }
        while(left != null) {
            curr.next = left;
            left = left.next;
            curr = curr.next;
        }
        while(right != null) {
            curr.next = right;
            right = right.next;
            curr =curr.next;
        }
        curr.next = null;
        return dummy.next;
    }
}