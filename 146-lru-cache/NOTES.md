```
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