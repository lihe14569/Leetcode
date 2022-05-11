class Trie:

    def __init__(self):
        self.root = Node()

    def insert(self, word: str) -> None:
        curr = self.root
        for c in word:
           curr = curr.children[c]
        curr.is_word= True
        

    def search(self, word: str) -> bool:
        curr = self.root
        for c in word:
            if not curr.children.get(c):
                return False
            curr = curr.children[c]
        return curr.is_word

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for c in prefix:
            if not curr.children.get(c):
                return False
            curr = curr.children[c]
        return True
    
class Node:
    def __init__(self):
        self.children = defaultdict(Node)
        self.is_word = False

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)