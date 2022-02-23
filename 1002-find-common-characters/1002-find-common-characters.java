class Solution {
    public List<String> commonChars(String[] words) {
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for(String str : words) {
            int[] cnt = new int[26];
            for(char c : str.toCharArray()) cnt[c - 'a']++;
            
            for(int i = 0; i < 26; i++) {
                count[i] = Math.min(count[i], cnt[i]);
            }
        }
        List<String> res = new ArrayList<>();
        for(char c = 'a'; c <= 'z'; c++) {
            while(count[c - 'a'] > 0) {
                count[c -'a']--;
                res.add("" + c);
            }
        }
        return res;
    }
}