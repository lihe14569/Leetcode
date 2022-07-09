/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    List<Node> lst = new ArrayList<>();
    public Node inorderSuccessor(Node node) {
        Node p = node; 
        if(p.right != null) {
            p = p.right;
            while(p.left != null) {
                p = p.left;
            }
            return p; 
        }
        else {
            p = node;
            while(p.parent != null && p.parent.right == p)
                p = p.parent;
            return p.parent;
        }
    }
}