class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        int max = -1;
        while(l < r) {
            int sum = nums[l] + nums[r];
            if(sum < k) {
                max = Math.max(max, sum);
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}