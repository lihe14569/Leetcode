class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null) return false;
        if(nums.length == 1 && nums[0] == target) return true;
        int left = 0;
        while(left < nums.length && nums[left] == nums[nums.length - 1]) left++;
        if(left >= nums.length) return nums[0] == target;
        
        int l = left, r = nums.length - 1;
    
        while(l < r) {
            int m = l + (r - l) / 2;
            if(nums[m] <= nums[r]) {
                r= m;
            } else {
                l = m + 1;
            }
        }
        
        if(target > nums[nums.length - 1]) {
            r = l;
            l = left;
        } else {
            r = nums.length - 1;
        }
        while(l < r) {
            int m = l +(r - l) / 2;
            if(nums[m] >= target) r = m;
            else l = m + 1;
        }
        return nums[l] == target ? true : false;
    }
}