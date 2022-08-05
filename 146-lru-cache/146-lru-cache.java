class LRUCache {
    class DLLNode {
        int key, val;
        DLLNode prev, next;
        public DLLNode(){};
        public DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    int size;
    int capacity;
    DLLNode head, tail;
    Map<Integer, DLLNode> cache;
    
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLLNode();
        tail = new DLLNode();
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            DLLNode node = cache.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }
    public void moveToHead(DLLNode node) {
        removeNode(node);
        addToHead(node);
    }
    public void removeNode(DLLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            DLLNode node = cache.get(key);
            node.val = value;
            moveToHead(node);
            return;
        } else {
            DLLNode node = new DLLNode(key, value);
            cache.put(key, node);
            addToHead(node);
            size++;
            if(size > capacity) {
                DLLNode lastNode = removeTail();
                cache.remove(lastNode.key);
                size--;
            }
        }
    }
    public DLLNode removeTail() {
        DLLNode node = tail.prev;
        removeNode(node);
        return node;
    }
    public void addToHead(DLLNode node) {
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */