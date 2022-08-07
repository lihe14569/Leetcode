class Solution {
        public int longestIdealString(String s, int k) {
        int res = 0, n = s.length(), dp[] = new int[150];
        for (int ci = 0; ci < n; ++ci) {
            int cur = 0, i = s.charAt(ci);
            for (int j = i - k; j <= i + k; ++j)
                cur = Math.max(cur, dp[j] + 1);
            res = Math.max(res, dp[i] = cur);
        }
        return res;
    }
}