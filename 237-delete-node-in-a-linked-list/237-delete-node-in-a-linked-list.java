/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        //思路：将下一个点value赋给要删除点，然后删除一下个节点
        node.val = node.next.val;
        node.next = node.next.next;
    }
}