class Solution {
    public int countKDifference(int[] nums, int k) {
        int[] cnt = new int[101];
        for(int num : nums) cnt[num]++;
        int res = 0;
        for(int i = k + 1; i < 101; i++) {
            res += cnt[i] * cnt[i - k];
        }
        return res;
    }
}