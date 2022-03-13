class Solution {
    public int maximumTop(int[] nums, int k) {
        //case1: n == 1
        // case2 n > 1
        //            n > k
        //            n < k
        //            n == k
        int n = nums.length;
        //case1
        if(n == 1) {
            if(k % 2 == 0) return nums[0];
            else return  -1;
        }
        //case2
        int max = 0;
        if(k < n)  max = nums[k];
        else if(k > n) k = n + 1;
        for(int i = 0; i < k - 1; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}