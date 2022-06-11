class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum < x) return -1;
        int l = 0, res = Integer.MAX_VALUE, curr = 0, target = sum - x;
        for(int i = 0; i < nums.length; i++) {
            curr += nums[i];
            while(l <= i && curr > target) {
                curr -= nums[l++];
            }
            if(sum - x == curr) res = Math.min(res,nums.length - (i - l + 1));
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}