class Solution {
    public int search(int[] nums, int target) {
        //find the smallest element
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] <= nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if(nums[nums.length - 1] >= target) {
            r= nums.length - 1;
        } else {
            r = l - 1;
            l = 0;
        }
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] >= target) {
                r  = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l] == target ? l : -1;
    }
}