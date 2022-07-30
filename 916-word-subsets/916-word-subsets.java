class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res  = new ArrayList<>();
        int[] map = new int[26];
        for(String w : words2) {
            int[] temp = counter(w);
            for(int i = 0; i < 26; i++) {
                map[i] = Math.max(map[i], temp[i]);
            }
        }
        for(String w : words1) {
            int[] temp = counter(w);
            int i = 0;
            for(; i< 26; i++) {
                if(temp[i] < map[i]) break;
            }
            if(i == 26) res.add(w);
        }
        return res;
    }
    public int[] counter(String word) {
        int[] map = new int[26];
        for(char c : word.toCharArray()) {
            map[c - 'a']++;
        }
        return map;
    }
}