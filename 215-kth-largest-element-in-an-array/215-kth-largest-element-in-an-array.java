class Solution {
    public int findKthLargest(int[] nums, int k) {

        int l = -10000, r = 10000;
        while(l < r) {
            int m =(l + r + 1) / 2;
            int count = ge(nums, m);
            if(count >= k) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
    public int ge(int[] nums, int m) {
        int res = 0;
        for(int num : nums) {
            if(num >= m) res++;
        }
        return res;
    }
}