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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length== 0) return null;
        return divide(lists, 0, lists.length - 1);
    }
    public ListNode divide(ListNode[] lists, int start, int end) {
        //base case
        if(start == end) return lists[start];
        int mid = start + (end -start ) / 2;
        ListNode left = divide(lists, start, mid);
        ListNode right = divide(lists, mid + 1, end);
        return merge(left, right);
    }
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 == null) curr.next = l2;
        else curr.next = l1;
        return head.next;
    }
}