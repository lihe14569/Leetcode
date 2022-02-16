class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(){}
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    int capacity;
    int size;
    Node head, tail;
    Map<Integer, Node> map; 
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) {
            return -1;
        } else {
            int res = node.val;
            moveHead(node);
            return res;
        }
    }
    public void moveHead(Node node) {
        removeNode(node);
        addHead(node);
    }
    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void addHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node == null) {
            node = new Node(key, value);
            addHead(node);
            map.put(key, node);
            size++;
            if(size > capacity) {
                Node rTail = removeTail();
                map.remove(rTail.key);
                size--;
            }
        } else{
            node.val = value;
            moveHead(node);
        }
    }
    public Node removeTail() {
        Node node = tail.prev;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */