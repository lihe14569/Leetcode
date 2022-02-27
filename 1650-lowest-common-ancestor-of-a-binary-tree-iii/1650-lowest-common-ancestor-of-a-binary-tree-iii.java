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
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> set = new HashSet<>();
        while(true) {
            if(p != null && !set.add(p)) return p;
            if(q != null && !set.add(q)) return q;
            if(p != null) p = p.parent;
            if(q != null) q = q.parent;
        }
    }
}