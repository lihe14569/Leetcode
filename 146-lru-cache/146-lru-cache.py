class Node:
    def __init__(self, key = 0, val = 0, next = None, prev = None):
        self.key = key
        self.val = val
        self.next = next
        self.prev = prev
        
class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.size = 0
        self.cache = {}
        self.head, self.tail = Node(), Node()
        self.head.next = self.tail
        self.tail.prev = self.head
        
    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        else:
            node = self.cache[key]
            self.moveToHead(node)
        return node.val
    
    def moveToHead(self,node):
        self.deleteNode(node)
        self.addToHead(node)
    
    def deleteNode(self, node):
        node.prev.next = node.next
        node.next.prev = node.prev
    
    def addToHead(self, node):
        node.next = self.head.next
        node.prev = self.head
        
        self.head.next.prev = node
        self.head.next = node

    def removeTail(self):
        tail = self.tail.prev
        self.deleteNode(tail)
        return tail
        
    def put(self, key: int, value: int) -> None:
        node = self.cache.get(key)
        if not node:
            node = Node(key, value)
            self.cache[key] = node
            
            self.addToHead(node)
            self.size += 1
            if self.size > self.capacity:
                tail= self.removeTail()
                self.cache.pop(tail.key)
                self.size -= 1
        else:
            node.val = value
            self.moveToHead(node)
            
        
        
            


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)