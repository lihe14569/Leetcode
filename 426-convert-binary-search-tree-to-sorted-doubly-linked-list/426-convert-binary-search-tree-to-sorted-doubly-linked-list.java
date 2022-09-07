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
    Node head;
    Node tail;
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        head = null;
        tail = null;
        inorder(root);
        head.left = tail;
        tail.right = head;
        return head;
    }
    public void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        if(head == null) head = root;
        else {
            tail.right = root;
            root.left = tail;
        }
        tail = root;
        inorder(root.right);
    }
}