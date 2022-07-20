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
        if(lists == null || lists.length == 0) return null;
        return divide(lists, 0, lists.length - 1);
    }
    public ListNode divide(ListNode[] lists, int start, int end) {
        if(start == end) return lists[start];
        int mid = start + (end - start) / 2;
        ListNode left = divide(lists, start, mid);
        ListNode right = divide(lists, mid + 1, end);
        return merge1(left, right);
    } 
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 != null) curr.next = l1;
        else curr.next = l2;
        return dummy.next;
    }
    public ListNode merge1(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val <= l2.val) {
            l1.next = merge1(l1.next, l2);
            return l1;
        } else {
            l2.next = merge1(l2.next, l1);
            return l2;
        }
    }
}