class Solution {
    public int longestSubsequence(String s, int k) {
        String ks = Integer.toBinaryString(k);
        int m = s.length(), n = ks.length();
        if(m < n) return m;
        int res = n - 1;
        for(int i = 0; i < m - n  + 1; i++) {
            if(s.charAt(i) == '0') res++;
        }
        if(s.substring(m - n).compareTo(ks) <= 0) {
            int cnt = 0;
            for(int i = 0; i < m - n; i++) {
                if(s.charAt(i) == '0') cnt++;
            }
            res = Math.max(res, cnt + n);
        }
        return res;
    }
}