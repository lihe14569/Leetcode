class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return helper(text1, text2, 0, 0, new Integer[text1.length()][text2.length()]);
    }
    
    public int helper(String s1, String s2, int i, int j, Integer[][] memo) {
        //base case
        if(i == s1.length() || j == s2.length()) return 0;
        if(memo[i][j] != null) return memo[i][j];
        
        if(s1.charAt(i) == s2.charAt(j))
            memo[i][j] = 1 + helper(s1, s2, i + 1, j + 1, memo);
        else
            memo[i][j] = Math.max(helper(s1, s2, i, j + 1, memo), helper(s1, s2, i + 1, j, memo));
        return memo[i][j];
    }
}