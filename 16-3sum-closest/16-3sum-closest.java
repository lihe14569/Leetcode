class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            if(i != 0 && nums[i] == nums[i - 1])continue;
            int l = i + 1, r = nums.length - 1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    res = sum;
                }
                if(sum > target) r--;
                else l++;
            }
        }
        return res;
    }
}