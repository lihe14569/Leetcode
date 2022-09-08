/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node head, tail;
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        head = null;
        tail = null;
        dfs(root);
        head.left = tail;
        tail.right = head;
        return head;
    }
    public void dfs(Node root) {
        if(root == null) return ;
        dfs(root.left);
        if(head == null) head = root;
        else {
            tail.right = root;
            root.left =tail;
        }
        tail = root;
        dfs(root.right);
    }
}