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
    Map<Node, Node> visited = new HashMap<>();
    public Node copyRandomList(Node head) {
        
        if(head == null) return head;
        
        if(visited.containsKey(head)) return visited.get(head);
        else {
            Node newNode = new Node(head.val);
            visited.put(head, newNode);
            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
        }
        return visited.get(head);
    }
}