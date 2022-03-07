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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        //dummy node method
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, curr = head;
        
       while(curr != null ) {
          //duplicates 
           if(curr.next != null && curr.val == curr.next.val) {
               while(curr.next != null && curr.val == curr.next.val)
                   curr = curr.next;
               //remove all the duplicated nodes
               pre.next = curr.next;
           }
           //move predecessor forward
           else {
               pre = pre.next;
           }
          curr = curr.next;
       }
        return dummy.next;
    }
}