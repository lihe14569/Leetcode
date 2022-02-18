class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int m = l + (r - l) / 2;
            if(m  < nums.length - 1 && nums[m] > nums[m  + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}