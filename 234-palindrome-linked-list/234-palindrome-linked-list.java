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
        Stack<ListNode> stack = new Stack<>();
        ListNode f = head, s = head;
        while(s != null && s.next != null) {
            s = s.next.next;
            f = f.next;
        }
        if(s != null) f = f.next;
        
        while(f != null) {
            stack.push(f);
            f = f.next;
        }
        s = head;
        while(!stack.isEmpty()) {
            if(s.val != stack.peek().val) return false;
            s = s.next;
            stack.pop();
        }
        return true;
    }
}