class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        
        //base case
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for(int i = 2; i <= s.length(); i++) {
            int one = Integer.valueOf(s.substring(i - 1, i));
            int two = Integer.valueOf(s.substring(i - 2, i));
            if(one != 0) dp[i] += dp[i - 1];
            if(two >= 10 && two <= 26) dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }
}