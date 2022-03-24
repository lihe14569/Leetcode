class Solution {
    public int jump(int[] nums) {
        //top down
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return canJump(0, nums, memo);
    }
    public int canJump(int start, int[] nums, int[] memo) {
        if(start >= nums.length  - 1) return  0;
        if(memo[start] != - 1) return memo[start];
        int step = nums.length;
        int max = Math.max(start + nums[start], nums.length - 1);
        for(int i = 1; i <= nums[start]; i++) {
            step = Math.min(step, 1 + canJump(start + i, nums, memo));
        }
        return memo[start] = step;
    }
}