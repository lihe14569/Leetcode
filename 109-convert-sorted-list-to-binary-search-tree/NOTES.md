```
class Solution {
public TreeNode sortedListToBST(ListNode head) {
return toBST(head);
}
public TreeNode toBST(ListNode head) {
if(head == null) return null;
if(head.next == null) return new TreeNode(head.val);
ListNode pre = head, slow = head, fast = head;
//find the midpoint of the sorted linkedlist
while(fast != null && fast.next != null) {
pre = slow;
slow = slow.next;
fast = fast.next.next;
}
//partitioned the list into two sublists
pre.next = null;
TreeNode root = new TreeNode(slow.val, toBST(head), toBST(slow.next));
// root.left = toBST(head);
// root.right = toBST(slow.next);
return root;
}
}
```
​
python solution
```
def sortedListToBST(self, head: Optional[ListNode]) -> Optional[TreeNode]:
def dfs(root):
if not root:
return None
if not root.next:
return TreeNode(root.val)
prev = fast = slow = root
while fast and fast.next:
prev = slow
slow = slow.next
fast = fast.next.next
prev.next = None
nRoot = TreeNode(slow.val, dfs(root), dfs(slow.next))
return nRoot
return dfs(head)
```