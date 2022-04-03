class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int cmax = 0, tmax = nums[0];
        int cmin = 0, tmin = nums[0];
        int sum = 0;
        for(int num : nums) {
            cmax = Math.max(cmax + num, num);
            tmax = Math.max(tmax, cmax);
            cmin = Math.min(cmin + num, num);
            tmin = Math.min(tmin, cmin);
            sum += num;
        }
        return tmax < 0 ? tmax : Math.max(tmax, sum - tmin);
    }
}