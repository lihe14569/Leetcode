class Solution {
    public int findPairs(int[] nums, int k) {
        //sort + two pointer
        Arrays.sort(nums);
        int l = 0, r = 0, n = nums.length;
        int res = 0;
        while(l < n && r < n) {
            if(l == r || nums[l] + k > nums[r]) r++;
            else if(nums[l] + k < nums[r]) l++;
            else {
                res++;
                l++;
                while(l < n && nums[l] == nums[l - 1]) l++;
            }
        }
        return res;
    }
}