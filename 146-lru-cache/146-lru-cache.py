class Node():
    def __init__(self, key = 0, val = 0):
        self.key = key
        self.val = val
        self.prev= None
        self.next = None
        
class LRUCache:
    def addNode(self, node):
        node.prev = self.head
        node.next = self.head.next
        
        self.head.next.prev = node
        self.head.next = node
    
    def removeNode(self,node):
        node.next.prev = node.prev
        node.prev.next = node.next
        
    def moveToHead(self, node):
        self.removeNode(node)
        self.addNode(node)
        
    def removeTail(self):
        tail = self.tail.prev
        self.removeNode(tail)
        return tail
    
    def __init__(self, capacity: int):
        self.cache = {}
        self.capacity = capacity
        self.size = 0
        self.head, self.tail = Node(), Node()
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key: int) -> int:
        node = self.cache.get(key)
        if not node: return -1
        
        self.moveToHead(node)
        return node.val

    def put(self, key: int, value: int) -> None:
        node = self.cache.get(key)
        if not node:
            newNode = Node(key, value)
            self.cache[key] = newNode
            self.addNode(newNode)
            self.size += 1
            
            if self.size > self.capacity:
                tail = self.removeTail()
                self.cache.pop(tail.key)
                self.size -= 1
        else:
            node.val = value
            self.moveToHead(node)


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)