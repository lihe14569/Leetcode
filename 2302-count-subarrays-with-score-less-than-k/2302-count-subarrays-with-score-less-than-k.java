class Solution {
    public long countSubarrays(int[] nums, long k) {
        long[] ps = new long[nums.length + 1];
        for(int i = 1; i <= nums.length; i++) {
            ps[i] = ps[i - 1] + nums[i - 1];
        }
        int l = 0, curr = 0;
        long cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            while((ps[i + 1] - ps[l]) * (i - l + 1) >= k) {
                l++;
            }
            cnt += i - l + 1;
        }
        return cnt;
    }
}