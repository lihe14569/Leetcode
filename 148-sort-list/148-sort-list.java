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
      //iterative sort
        if(head == null || head.next == null) return head;
        int n = 0;
        for(ListNode p = head; p != null; p=p.next) n++;
        ListNode dummy = new ListNode();
        dummy.next = head;
        for(int i=1; i < n; i *= 2) {
             ListNode curr = dummy;
            for(int j = 0; j + i < n; j += 2 * i) {
                ListNode first= curr.next, second = curr.next;
                for(int k = 0; k < i; k++) second = second.next;
                int l = 0, r = 0;
                while(l < i && r < i && second != null) {
                    if(first.val <= second.val) {
                        curr.next = first;
                        first = first.next;
                        curr = curr.next;
                        l++;
                    } else {
                        curr.next =second;
                        second = second.next;
                        curr =curr.next;
                        r++;
                    }
                }
                while(l < i) {
                    curr.next =first;
                    first = first.next;
                    curr =curr.next;
                    l++;
                }
                while(r < i && second != null) {
                    curr.next = second;
                    second = second.next;
                    curr= curr.next;
                    r++;
                }
                curr.next = second;
            }
        }
        return dummy.next;
    }
}