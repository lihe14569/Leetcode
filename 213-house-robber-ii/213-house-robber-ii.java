class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int length = nums.length;
        int ans = Math.max(robsub(nums, 0, length -1), robsub(nums, 1, length));
        return ans;
    }
    
    private int robsub(int[] nums, int start, int end){
        int pre1 = 0;
        int pre2 = 0;
        int curr = 0;
        for(int i = start; i < end; i++){
            curr = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = curr;
        }
        return curr;
    }
}
