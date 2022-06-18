class WordFilter {
    Trie root;
    String[] words;
    
    class Trie {
        Trie[] children;
        List<Integer> index;
        
        Trie() {
            children = new Trie[26];
            index = new ArrayList<>();
        }
        
    }
    //put the word and index in the trie
    public WordFilter(String[] words) {
        root = new Trie();
        this.words = words;
        for(int i = 0; i < words.length; i++) {
            Trie node = root;
            for(char ch : words[i].toCharArray()) {
                if(node.children[ch - 'a'] == null)
                    node.children[ch - 'a'] = new Trie();
                node = node.children[ch - 'a'];
                node.index.add(i);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        Trie node = root;
        for(char c : prefix.toCharArray()) {
            if(node.children[c - 'a'] == null)
                return -1;
            node = node.children[c - 'a'];
        }
        List<Integer> lst = node.index;
        for(int i = lst.size() -1; i >= 0; i--) {
            if(words[lst.get(i)].endsWith(suffix))
                return lst.get(i);
        }
        return -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */