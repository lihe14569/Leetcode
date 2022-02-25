class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int[] count = new int[1001];
        for(int num : nums) {
            count[num]++;
        }
        int l = 0, r = 999;
        int max = -1;
        while(l < r) {
            if(count[r] == 0 || l + r >= k) {
                r--;
            } else {
                if(count[l] > 0 && l + r < k) {
                    max = Math.max(max, l + r);
                }
                l++;
            }
        }
        if(count[l] > 1 && max < l + r && l + r < k) max = l + r;
        return max;
    }
}