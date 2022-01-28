class WordDictionary {
    //how to handle '.'
    public class Trie {
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
        Trie node = root;
        for(char c : word.toCharArray()) {
            if(node.children[c - 'a'] == null) {
                node.children[c- 'a'] = new Trie();
            }
            node = node.children[c -'a'];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        Trie node = root;
        return searchPrefix(word, 0, node);
    }
    public boolean searchPrefix(String word, int pos, Trie node) {
        if(pos == word.length()) return node.isWord;
        for(int i = pos; i < word.length(); i++) {
            char c = word.charAt(i);
           if(Character.isLetter(c)) {
                if(node.children[c - 'a'] == null) return false;
                return searchPrefix(word, pos + 1, node.children[c - 'a']);
            } else if(c == '.') {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    if(node.children[ch - 'a'] != null && searchPrefix(word, pos + 1, node.children[ch - 'a'])) return true;
                }
               return false;
           }   
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */