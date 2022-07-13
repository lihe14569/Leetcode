class LRUCache {
    Map<Integer, Node> map;
    Node head, tail;
    int size, capacity;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        size = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            moveToHead(node);
            return node.val;
        } 
        return -1;
    }
    
    public void moveToHead(Node node) {
        remove(node);
        addToHead(node);
    }
    
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
     public void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    
    public Node removeTail() {
        Node node = tail.prev;
        remove(node);
        return node;
    }
    
    public void put(int key, int value) {
        //1. exist, update value, move to head
        //2. not exist, add node to head, update map. if exceeds the capacity, evict last node
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            Node node = new Node(key, value);
            addToHead(node);
            map.put(key, node);
            size++;
            if(size > capacity) {
                Node rmNode = removeTail();
                map.remove(rmNode.key);
                size--;
            }
        }
    }
   
}
class Node {
    int key, val;
    Node next, prev;
    public Node(){};
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */