class Solution {
    public int deleteAndEarn(int[] nums) {
        //robber + bucket
        int[] bucket = new int[10001];
        for(int num : nums) bucket[num]++;
        
        //rob game
        int[] dp = new int[10001];
        dp[0] = 0;
        dp[1] = bucket[1];
        
        for(int i = 2; i <= 10000; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i*bucket[i]);
        }
        return dp[10000];
    }
}