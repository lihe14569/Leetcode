class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        //初始一个值，确保可以比较
        Integer res = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            res = twoSum(nums, i, l, r, target, res);
        }
        return res;
    }
    public int twoSum(int[] nums, int i, int l, int r, int target, Integer res) {
        while(l < r) {
            int sum = nums[i] + nums[l] + nums[r];
            if(Math.abs(sum - target) < Math.abs(res - target)) {
                res = sum;
                // System.out.println("res: " + res);
            }
            if(sum > target) r--;
            else l++;
        }
        return res;
    }
}