class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;
        for(char c : word.toCharArray()) {
            if(node.children[c - 'a'] == null) node.children[c - 'a'] = new Node();
            node = node.children[c - 'a'];
        }
        node.isWord= true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    public boolean dfs(String word, int index, Node root) {
        if(index == word.length()) return root.isWord;
        Node node = root;
        char c = word.charAt(index);
        if(c == '.') {
            for(int i = 0; i < 26; i++) {
                if(node.children[i] != null && dfs(word, index + 1, node.children[i]))
                    return true;
            }
            return false;
        } else {
            if(node.children[c - 'a'] == null) return false;
            return dfs(word, index + 1, node.children[c - 'a']);
        }
    }
    
    class Node {
        Node[] children;
        boolean isWord;
        public Node() {
            children = new Node[26];
            isWord = false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */