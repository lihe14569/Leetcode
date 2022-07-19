class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1, k = nums.length -1; j < k; j++) {
                while(k - 1 > j && nums[i] + nums[j] + nums[k - 1] >= target) k--;
                int sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    res = sum;
                }
                if(k - 1 > j) {
                    sum = nums[i] + nums[j] + nums[k - 1];
                    if(target - sum < diff) {
                        diff = target - sum;
                        res = sum;
                    }
                }
            }
        }
        return res;
    }
}