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
    //思路：condition1:下一个节点的值和当前值一样，删除一下个节点
    //     condition2:下一个节点的值和当前值不一样，当前节点移动到下一节点
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        //判断当前节点是否为空为结束条件 ***重要
        
        while(curr != null) {
            if(curr.next != null && curr.val == curr.next.val)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
        return head;
    }
}