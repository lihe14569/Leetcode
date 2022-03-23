class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] bucket = new int[10001];
        for(int num : nums) bucket[num] += num;
        int[] dp = new int[10002];
        dp[0] = 0;
        dp[1] = bucket[0];
        for(int i = 2; i <= 10001; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + bucket[i - 1]);
        }
        return dp[10001];
    }
}