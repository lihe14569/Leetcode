class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        trie = Trie()
        for w in wordDict:
            trie.add(w)
        res = []
        def dfs(i, lst):
            if i >= len(s):
                res.append(lst[:])
                return 
            prefix = trie.search(s[i:])
            for pre in prefix:
                lst.append(s[i: i + pre + 1])
                dfs(i + pre + 1, lst)
                lst.pop()
                
        
        dfs(0, [])
        return [' '.join(l) for l in res]
    
class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_word = False
class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def add(self, word):
        curr = self.root
        for c in word:
            if c not in curr.children:
                curr.children[c] = TrieNode()
            curr = curr.children[c]
        curr.is_word = True
    
    def search(self, word):
        curr = self.root
        ans = []
        for i, c in enumerate(word):
            if c not in curr.children:
                break
            curr = curr.children[c]
            if curr.is_word:
                ans.append(i)
        return ans
    
        
            
                
        