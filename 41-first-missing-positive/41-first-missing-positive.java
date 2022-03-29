class Solution {
    public int firstMissingPositive(int[] nums) {
        int countOne = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) countOne++;
        }
        if(countOne == 0) return 1;
        
        //mark out of range number as 1
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0 || nums[i] > nums.length) nums[i] = 1; 
        }
        
        for(int i = 0; i < nums.length; i++) {
            int curr = Math.abs(nums[i]);
            if(curr == nums.length) nums[0] = -Math.abs(nums[0]);
            else nums[curr] = -Math.abs(nums[curr]);
        }
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > 0) return i;
        }
        if(nums[0] > 0) return nums.length;
        return nums.length + 1;
    }
}