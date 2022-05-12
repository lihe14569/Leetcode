方法一：
```
lass Node{
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