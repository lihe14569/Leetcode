class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        int l = 0, r = 0;
        for(int i = 0; i < s.length(); i++) {
            int odd = findPanlindrome(s, i, i);
            int even = findPanlindrome(s, i, i + 1);
            int currMax = Math.max(odd, even);
            if( currMax > r - l) {
                l = i - (currMax - 1) / 2;
                r = i + currMax / 2;
            }
        }
        return s.substring(l, r + 1);
    }
    public int findPanlindrome(String s, int l, int r) {
        int left = l, right = r;
        while( left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left -1;
    }
}