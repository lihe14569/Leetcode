class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = 0;
        for(int i = 0; i < n; i++) {
            int idx = Arrays.binarySearch(dp, 0, res, nums[i]);
            if(idx < 0) idx = -idx - 1;
            dp[idx] = nums[i];
            if(idx == res) res++;
        }
        return res;
    }
}