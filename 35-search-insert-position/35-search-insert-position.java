class Solution {
    public int searchInsert(int[] nums, int target) {
        //
        int n = nums.length;
        if(nums[n - 1] < target) return n;
        int left = 0, right = n - 1;
        while(left < right) {
            int mid = left + (right - left) / 2 ;
            if(nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}