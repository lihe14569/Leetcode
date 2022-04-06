/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    dummy := &ListNode{Val: -1}
    val1, val2, carry, curr := 0, 0 , 0, dummy
    
    for l1 != nil || l2 != nil || carry != 0 {
        if l1 == nil {
            val1 = 0
        } else {
            val1 = l1.Val
            l1 = l1.Next
        }
        if l2 == nil {
            val2 = 0
        } else {
            val2 = l2.Val
            l2 = l2.Next
        }
        curr.Next = &ListNode{Val: (val1 + val2 + carry) % 10}
        curr = curr.Next
        carry = (val1 +val2 +carry) / 10
    }
    return dummy.Next
}