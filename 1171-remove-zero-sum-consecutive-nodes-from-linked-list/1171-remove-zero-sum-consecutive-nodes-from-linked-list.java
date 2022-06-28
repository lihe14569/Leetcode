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
    public ListNode removeZeroSumSublists(ListNode head) {
        int prefix = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, dummy);
        for(ListNode curr = dummy; curr != null; curr = curr.next) {
            prefix += curr.val;
            map.put(prefix, curr);
        }
        prefix = 0;
        for(ListNode curr = dummy; curr != null; curr = curr.next) {
            prefix += curr.val;
            curr.next = map.get(prefix).next;
        }
        return dummy.next;
    }
}