class Solution {
    class Trie {
        Trie[] children;
        public Trie() {
            this.children = new Trie[2];
        }
    }
    public int findMaximumXOR(int[] nums) {
        //bitwise trie
        int max = Integer.MIN_VALUE;
        for(int num : nums) max = Math.max(num, max);
        int len = (Integer.toBinaryString(max).length());
        Trie root = new Trie();
        //构造trie
        for(int num : nums) {
            Trie node = root;
            for(int i = len - 1; i >=0; i--) {
                int bit = (num >> i) & 1;
                if(node.children[bit] == null) {
                    node.children[bit] = new Trie();
                }
                node = node.children[bit];
            }
        }
        //找最大的xor
        int maxXOR = 0;
        for(int num : nums) {
            Trie node = root;
            int currXOR = 0;
            for(int i = len - 1; i >=0; i--) {
                int bit = (num >> i) & 1;
                if(node.children[bit ^ 1] != null) {
                    currXOR = (currXOR << 1) | 1;
                    node = node.children[bit ^ 1];
                } else {
                    currXOR = currXOR << 1;
                    node = node.children[bit];
                }
            }
            maxXOR = Math.max(maxXOR, currXOR);
        }
        return maxXOR;
    }
}