/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        return clone(node);
    }
    public Node clone(Node node) {
        //base case
        if(node == null) return null;
        //
        if(map.containsKey(node.val)) return map.get(node.val);
        Node nNode = new Node(node.val);
        map.put(nNode.val, nNode);
        for(Node neigh : node.neighbors) {
            nNode.neighbors.add(clone(neigh));
        }
        return nNode;
    }
}