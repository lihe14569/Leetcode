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
    public Node cloneGraph(Node node) {
        //bfs
        if(node == null) return null;
        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> visited = new HashMap<>();
        q.offer(node);
        visited.put(node, new Node(node.val));
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node n = q.poll();
                for(Node neigh : n.neighbors) {
                    if(!visited.containsKey(neigh)) {
                        visited.put(neigh, new Node(neigh.val));
                        q.offer(neigh);
                    }
                    visited.get(n).neighbors.add(visited.get(neigh));
                }
            }
        }
        return visited.get(node);
    }
}