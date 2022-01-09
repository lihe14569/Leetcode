class Solution {
    public int countSubstrings(String s) {
        //dp
        int n = s.length();
        int l = 0, r = 0, res = 0;
        
        for(int i = 0; i < n; i++) {
            int len1 = findPanlindrome(s, i, i);
            int len2 = findPanlindrome(s, i , i + 1);
            res += len1 + len2;
        }
        return res;
    }
    public int findPanlindrome(String s, int l, int r) {
        int res = 0;
        
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
            res++;
        }
        return res;
    }
}