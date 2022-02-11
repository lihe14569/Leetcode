class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        //find first element in sorted array
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int m = (l + r) / 2;
            if(nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        if(nums[l] != target) return new int[]{-1, -1};
        int left = l;
        r = nums.length - 1;
        
        while( l < r) {
            int m = (l + r + 1) / 2;
            if(nums[m] <= target)
                l = m;
            else 
                r = m - 1;
        }
        
        int right = l;
        return new int[]{left, right};
    }
}