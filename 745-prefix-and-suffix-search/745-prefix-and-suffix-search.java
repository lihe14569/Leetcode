class WordFilter {
    class Trie {
        Trie[] children;
        int weight;
        Trie() {
            children = new Trie[27];
            weight = 0;
        }
    }
    Trie root;
    public WordFilter(String[] words) {
        root = new Trie();
        for(int i = 0; i < words.length; i++) {
            String word = "{" + words[i];
            insert(root, word, i); //有必要吗
            for(int j = 0; j < word.length(); j++) {
                String nWord = word.substring(1 + j) + word;
                insert(root, nWord, i);
            }
        }
    }
    public void insert(Trie root, String word, int idx) {
        Trie node = root;
        for(char c : word.toCharArray()) {
            if(node.children[c - 'a'] == null) 
                node.children[c - 'a'] = new Trie();
            node = node.children[c - 'a'];
            node.weight = idx;
        }
    }
    
    public int f(String prefix, String suffix) {
        Trie node = root;
        String target = suffix + "{" + prefix;
        for(char c : target.toCharArray()) {
            if(node.children[c - 'a'] == null) return -1;
            node = node.children[c - 'a'];
        }
        return node.weight;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */