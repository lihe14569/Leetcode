/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
     //recursion -> graph
    
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node, Node> visited = new HashMap<>();
        Node oldHead = head;
        Node newNode = new Node(head.val);
        visited.put(head, newNode);
        
        while(newNode!= null) {
            newNode.random = getNode(oldHead.random, visited);
            newNode.next = getNode(oldHead.next, visited);
            newNode = newNode.next;
            oldHead = oldHead.next;
        }
        return visited.get(head);
    }
    public Node getNode(Node node, Map<Node, Node> visited) {
        if(node == null) return null;
        if(visited.containsKey(node)) return visited.get(node);
        else {
            Node newNode = new Node(node.val);
            visited.put(node, newNode);
            return visited.get(node);
        }
    }
}