class Solution {
    Integer[] memo;
    public int jump(int[] nums) {
        int n = nums.length;
        memo = new Integer[n];
        return helper(nums, 0);
    }
    public int helper(int[] nums, int start) {
        //base case
        if(start >= nums.length - 1) return 0;
        if(memo[start] != null) return memo[start];
        int step = nums.length;
        for(int i = 1; i <= nums[start]; i++) {
            step = Math.min(step, 1 + helper(nums, start + i));
        }
        return memo[start] = step;
    }
}