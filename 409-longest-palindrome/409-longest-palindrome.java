class Solution {
    public int longestPalindrome(String s) {
        int[] cnt = new int[256];
        for(int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)] += 1;
        }
        int res= 0;
        for(int val : cnt) {
            res += val / 2 * 2;
        }
        if(res < s.length())
            res ++;
        return res;
    }
}