class Solution {
    public int firstUniqChar(String s) {
        int[] chrs = new int[26];
        for(char c : s.toCharArray()) {
            chrs[c - 'a'] ++;
        }
        for(int i = 0; i < s.length(); i++) {
            if(chrs[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}