class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length]; //dp代表从0 到i 能到达的最远index
        if(nums.length == 1) return true;
        dp[0] = nums[0];
        for(int i = 1; i < nums.length - 1; i++) {
            if(dp[i - 1] < i) return false;
            dp[i] = Math.max(dp[i - 1], nums[i] + i);
            if(dp[i] >= nums.length - 1) return true;
        }
        return dp[nums.length - 2] >= nums.length - 1 ? true : false;
    }
}