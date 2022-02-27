class Solution {
    public int findKthLargest(int[] nums, int k) {
        int l = -10000, r = 10000;
        while(l < r) {
            int m = (l + r + 1)/ 2;
            int count = greatEqual(nums, m);
            if(count >= k) l = m;
            else r = m - 1;
        }
        return l;
    }
    public int greatEqual(int[] nums, int m) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= m) res++;
        }
        return res;
    }
}