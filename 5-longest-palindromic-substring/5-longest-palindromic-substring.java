class Solution {
    public String longestPalindrome(String s) {
        int l = 0, r = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            int len1 = len(s, i, i);
            int len2 = len(s, i, i + 1);
            int len = Math.max(len1, len2);
            if(len > r - l + 1) {
                l = i - (len - 1)/ 2;
                r = i + len / 2;
            }
        }
        return s.substring(l, r + 1);
    }
    int len(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}