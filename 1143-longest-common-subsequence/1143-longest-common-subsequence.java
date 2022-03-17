class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return helper(text1, text2, 0, 0, new Integer[text1.length()][text2.length()]);
    }
    public int helper(String s1, String s2, int p1, int p2, Integer[][] memo) {
        if(p1 >= s1.length() || p2 >= s2.length()) return 0;
        if(memo[p1][p2] != null) return memo[p1][p2];
        if(s1.charAt(p1) == s2.charAt(p2)) {
            memo[p1][p2] = 1 + helper(s1, s2, p1 + 1, p2 + 1, memo);
        } else 
            memo[p1][p2] = Math.max(helper(s1, s2, p1 + 1, p2, memo), helper(s1, s2, p1, p2 + 1, memo));
        return memo[p1][p2];
    }
}