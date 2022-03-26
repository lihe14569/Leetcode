class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = i; j <= s.length(); j++) {
                if(dict.contains(s.substring(i - 1, j)) && dp[ i - 1])
                    dp[j] = true; 
            }
        }
        return dp[s.length()];
    }
}