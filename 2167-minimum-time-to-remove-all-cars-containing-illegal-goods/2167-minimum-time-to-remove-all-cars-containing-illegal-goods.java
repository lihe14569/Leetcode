class Solution {
    public int minimumTime(String s) {
        int n = s.length();
        int[] rmR = new int[n + 1];
        //get minimum time removing car from right
        for(int i = n -1; i >= 0; i--) {
            rmR[i] = Math.min(rmR[i + 1] + (s.charAt(i) - '0') * 2, n - i);
        }
        //get minimum time from left
        int minLeft = 0, res = n;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '1') {
                minLeft = Math.min(minLeft + 2, i + 1);
            }
            res = Math.min(res, minLeft + rmR[i]);
        }
        return res;
    }
}