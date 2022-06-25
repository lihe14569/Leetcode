class Solution {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] <= nums[i])
                continue;
            //find non-decreasing order
            //1. greedy change
            //if nums[i - 1] > nums[i], we change nums[i-1]= nums[i]
            //there is a special case nums[i - 2] > nums[i], we can only change nums[i]
            cnt++;
            if(i - 2 >= 0 && nums[i - 2] > nums[i])
                nums[i] = nums[i - 1];
            else 
                nums[i - 1] = nums[i];
        }
        return cnt <= 1;
    }
}