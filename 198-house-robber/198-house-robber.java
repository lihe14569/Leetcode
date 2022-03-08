class Solution {
    Integer[] memo;
    public int rob(int[] nums) {
        //top down recursion
        int n = nums.length;
        memo = new Integer[n];
        return getVal(nums, n - 1);
    }
    public int getVal(int[] nums, int len) {
        if(len < 0) return 0;
        if(memo[len] != null) return memo[len];
        int res = Math.max(getVal(nums, len - 2) + nums[len], getVal(nums, len - 1));
        return memo[len] = res;
    }
}