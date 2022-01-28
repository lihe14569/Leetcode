class WordDictionary {
    class Trie {
        Trie[] children;
        boolean isWord;
        
        public Trie() {
            children = new Trie[26];
            isWord = false;
        }
     }
    Trie root;
    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        Trie node = this.root;
        for(char c : word.toCharArray()) {
            if(node.children[c - 'a'] == null) node.children[c -'a'] = new Trie();
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    
    public boolean dfs(String word, int i, Trie root) {
        Trie node = root;
        if(i == word.length()) return root.isWord;
        char c = word.charAt(i);
        if(c == '.') {
            for(int j = 0; j < 26; j++) {
                if(node.children[j] == null) continue;
                if(node.children[j] != null && dfs(word, i + 1, node.children[j])) return true;
            }
            return false;
        } else {
            if(node.children[c - 'a'] == null) return false;
            return dfs(word, i + 1, node.children[c - 'a']);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */