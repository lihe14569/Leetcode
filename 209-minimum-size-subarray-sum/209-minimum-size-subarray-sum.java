class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        
        for(int i = 1; i <=n; i++) prefix[i] = prefix[i - 1] + nums[i - 1];
        int res = Integer.MAX_VALUE, l = 0;
        for(int i = 1; i <= n; i++) {
            while(prefix[i] - prefix[l] >= target) {
                res = Math.min(res, i - l );
                l++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}