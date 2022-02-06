class Solution {
    public int minimumTime(String s) {
        int n = s.length(), left = 0, right = 0, res = n;
        //i represent the ith car is the last car to remove
        for(int i = 0; i < n; i++) {
            left = Math.min(left + (s.charAt(i) - '0') * 2, i + 1);
            res = Math.min(res, left + n - i - 1);
        }
        return res;
    }
}