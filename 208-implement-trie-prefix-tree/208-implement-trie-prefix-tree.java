class Trie {
    Trie[] children;
    boolean isWord;
    public Trie() {
        children = new Trie[26];
        isWord = false;
    }
    
    public void insert(String word) {
        Trie node = this;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null)
                node.children[c-'a'] = new Trie();
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isWord;
    }
    
    public Trie searchPrefix(String word) {
        Trie node = this;
        for(char c : word.toCharArray()) {
            if(node.children[c - 'a'] == null) return null;
            node = node.children[c -'a'];
        }
        return node;
    }
    
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */