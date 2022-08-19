class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int cnt = 0;
        for(int i = 1; i < nums.length && cnt < 2; i++) {
            if(nums[i -1] >= nums[i]) {
                cnt++;
                if(i > 1 && nums[i -2] >= nums[i])
                    nums[i] = nums[i - 1];
            }
        }
        return cnt < 2;
    }
}