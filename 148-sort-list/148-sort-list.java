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
        List<Integer> lst = new ArrayList<>();
        for(ListNode curr = head; curr != null; curr = curr.next) {
            lst.add(curr.val);
        }
        Collections.sort(lst);
        int i = 0;
        for(ListNode curr = head; curr != null; curr = curr.next) {
            curr.val = lst.get(i++);
        }
        return head;
    }
}