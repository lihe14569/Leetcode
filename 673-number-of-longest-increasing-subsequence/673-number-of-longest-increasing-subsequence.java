class Solution {
    public int findNumberOfLIS(int[] nums) {
        //O(N^2)
        int n = nums.length;
        int[] len = new int[n], cnt = new int[n];
        Arrays.fill(len, 1);
        Arrays.fill(cnt, 1);
        int max = 0;
        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(len[i] == len[j] + 1) {
                        cnt[i] += cnt[j];
                    } else if(len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if(max == len[i]) res += cnt[i];
            else if(max < len[i]) {
                max = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
}