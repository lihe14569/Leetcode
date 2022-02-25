class Solution {
    public List<String> commonChars(String[] words) {
        int[] commonCount = new int[26];
        Arrays.fill(commonCount, 100);
        for(String s : words) {
            int[] count = new int[26];
            for(char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            for(int i = 0; i < 26; i++){
                commonCount[i] = Math.min(commonCount[i], count[i]);
            }
        }
        List<String> res = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            while(commonCount[i] > 0) {
                char c = (char)(i + 'a');
                res.add("" + c);
                commonCount[i]--;
            }
        }
        return res;
    }
}