class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for(String s : strs) {
            trie.insert(s);
        }
        return trie.findPrefix();
    }
    class Node {
        Node[] children;
        int cnt;
        boolean isWord;
        Node() {
            children = new Node[26];
            cnt = 0;
            isWord = false;
        }
    }
    class Trie {
        Node root;
        Trie() {
            root = new Node();
        }
        public void insert(String w) {
            Node node = root;
            for(int i = 0; i < w.length(); i++) {
                if(node.children[w.charAt(i) - 'a'] == null) {
                    node.children[w.charAt(i) - 'a'] = new Node();
                    node.cnt++;
                }
                node = node.children[w.charAt(i) - 'a'];
            }
            node.isWord = true;
        }
        public String findPrefix() {
            Node node = root;
            StringBuilder sb = new StringBuilder();
            sb.append("");
            while(node.cnt == 1) {
                if(node.isWord) return sb.toString();
                for(int i =0; i < 26; i++) {
                    if(node.children[i] != null) {
                        sb.append((char)('a' + i));
                        node = node.children[i];
                        break;
                    }
                }
            }
            return sb.toString();
        }
        
    }
}