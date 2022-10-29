class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i <= s.length(); i++) {
            int twoD = Integer.parseInt(s.substring(i - 2, i));
            int oneD = Integer.parseInt(s.substring(i - 1, i));
            if(twoD >= 10 && twoD <= 26) dp[i] += dp[i - 2];
            if(oneD > 0 && oneD <= 9) dp[i] += dp[i - 1];
        }
        return dp[n];
    }
}