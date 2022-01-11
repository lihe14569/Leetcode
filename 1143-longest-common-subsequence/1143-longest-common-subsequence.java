class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //TOP DOWN: DFS+ MEMO
        int m = text1.length(), n = text2.length();
        //小技巧：如果不能确定是否访问的的值，可以用wrapper class
        Integer[][] memo = new Integer[m][n];
        return dfs(text1, text2, 0, 0, memo);
    }
    
    public int dfs(String text1, String text2, int s1, int s2, Integer[][] memo) {
        if(s1 >= text1.length() || s2 == text2.length()) return 0;
        if(memo[s1][s2] != null) return memo[s1][s2];
        if(text1.charAt(s1) == text2.charAt(s2)) {
            memo[s1][s2] = 1 + dfs(text1, text2, s1 + 1, s2 + 1, memo);
        } else {
            memo[s1][s2] = Math.max(dfs(text1, text2, s1 + 1, s2, memo), dfs(text1, text2, s1, s2 + 1, memo));
        }
        return memo[s1][s2];
    }
}