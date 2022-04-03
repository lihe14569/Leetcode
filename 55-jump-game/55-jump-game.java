class Solution {
    Boolean[] memo;
    public boolean canJump(int[] nums) {
        int n = nums.length;
        memo = new Boolean[n];
        return jump(nums, 0);
    }
    public boolean jump(int[] nums, int start) {
        if(start == nums.length - 1) return true;
        if(memo[start] != null) return memo[start];
        int next = Math.min(nums.length - 1, start + nums[start]);
        for(int i = start + 1; i<= next; i++) {
            if(jump(nums, i))
                return memo[start] = true;
        }
        return memo[start] = false;
    }
}