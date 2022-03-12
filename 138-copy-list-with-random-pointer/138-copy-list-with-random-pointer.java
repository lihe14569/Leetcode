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
    //method2: iterative + hashmap
    Map<Node, Node> visited = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node oldHead = head;
        Node newNode = new Node(head.val);
        visited.put(head, newNode);
        while(oldHead != null) {
            newNode.next = getNode(oldHead.next);
            newNode.random = getNode(oldHead.random);
            newNode = newNode.next;
            oldHead = oldHead.next;
        }
        return visited.get(head);
    }
    public Node getNode(Node node) {
        //base case
        if(node == null) return null;
        if(visited.containsKey(node)) return visited.get(node);
        else {
            //Create a new Node,put it into visited map
            Node newNode = new Node(node.val);
            visited.put(node, newNode);
            return newNode;
        }
    }
}