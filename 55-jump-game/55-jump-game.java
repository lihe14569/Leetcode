class Solution {
    Integer[] memo;
    public boolean canJump(int[] nums) {
        memo = new Integer[nums.length];
        return canJump1(0, nums) == 1;
    }
    public int canJump1(int start, int[] nums) {
        //base
        if(start == nums.length - 1) return memo[start] = 1;
        if(memo[start] != null) return memo[start];
        int max = Math.min(start + nums[start], nums.length - 1);
        for(int i = start + 1; i <= max; i++) {
            if(canJump1(i, nums) == 1) {
                return memo[start] = 1;
            }
        } 
        return memo[start] = -1;
    }
}