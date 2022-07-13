class MaxStack {
    TreeMap<Integer, List<Node>> map;
    Node head, tail;
    public MaxStack() {
        map = new TreeMap<>();
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public void push(int x) {
        Node node = new Node(x);
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        if(!map.containsKey(x)) {
            map.put(x, new ArrayList<>());
        }
        map.get(x).add(node);
    }
    
    public int pop() {
        Node node = tail.prev;
        int popVal = node.val;
        node.next.prev = node.prev;
        node.prev.next = node.next;
        
        List<Node> lst = map.get(popVal);
        lst.remove(lst.size() - 1);
        if(lst.size() == 0)
            map.remove(popVal);
        
        return popVal;
    }
    
    public int top() {
        return tail.prev.val;
    }
    
    public int peekMax() {
        return map.lastKey();
    }
    
    public int popMax() {
        int popval = peekMax();
        List<Node> lst = map.get(popval);
        Node node = lst.remove(lst.size() - 1);
        removeNode(node);
        if(lst.size() == 0) map.remove(popval);
        return popval;
    }
    public void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

}
class Node {
    int val;
    Node next, prev;
    public Node(int val) {
        this.val = val;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */