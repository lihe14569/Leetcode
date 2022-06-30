class LFUCache {
    class Node {
        int key, val;
        int cnt;
        Node prev, next;
        public Node(int k, int v) {
            key = k;
            val = v;
            cnt = 1;
        }
    }

    class DLList {
        Node head, tail;
        int len;
        public DLList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            len = 0;
        }

        public void addHead(Node node) {
            Node next = head.next;
            head.next = node;
            node.prev = head;
            node.next = next;
            next.prev = node;
            map.put(node.key, node);
            len++;
        }

        public void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            len--;
            map.remove(node.key);
        }

        public void removeTail() {
            Node prevTail = tail.prev;
            remove(prevTail);
        }
    }

    Map<Integer, Node> map;
    Map<Integer, DLList> freq;
    int size, capacity;
    int maxFreq;
    public LFUCache(int capacity) {
        map = new HashMap<>();
        freq = new HashMap<>();
        this.capacity = capacity;
        size = 0;
        maxFreq = 0;
    }

    public int get(int key) {
        if (map.get(key) == null) return -1;
        //等到node，存储频率和频率链表，将node从对应链表中删除
        Node node = map.get(key);
        int prevFreq = node.cnt;
        DLList prevList = freq.get(prevFreq);
        prevList.remove(node);
        //更新频率，最大频率，获得更新频率对应的链表，更新node的评率
        //将更新频率的node加入到更新频率对应的链表中
        int curFreq = prevFreq + 1;
        maxFreq = Math.max(maxFreq, curFreq);
        DLList curList = freq.getOrDefault(curFreq, new DLList());
        node.cnt++;
        curList.addHead(node);
        //更新之前频率和现在频率的freq 映射map
        freq.put(prevFreq, prevList);
        freq.put(curFreq, curList);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (map.get(key) != null) {
            map.get(key).val = value;
            get(key);
            return;
        }

        Node node = new Node(key, value);
        DLList curList = freq.getOrDefault(1, new DLList());
        curList.addHead(node);
        size++;
        

        if (size > capacity) {
            if (curList.len > 1) {
                curList.removeTail();
            } else {
                for (int i = 2; i <= maxFreq; i++) {
                    if (freq.get(i) != null && freq.get(i).len > 0) {
                        freq.get(i).removeTail();
                        break;
                    }
                }
            }

            size--;
        }

        freq.put(1, curList);
    }
}