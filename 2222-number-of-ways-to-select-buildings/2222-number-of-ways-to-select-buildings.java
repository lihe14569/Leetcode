class Solution {
    public long numberOfWays(String s) {
        long zero = 0, one = 0, zeroOne = 0, oneZero = 0, res = 0;
        for(char c : s.toCharArray()) {
            if(c == '0') {
                zero++;
                oneZero += one;
                res += zeroOne;
            } else {
                one++;
                zeroOne += zero;
                res += oneZero;
            }
        }
        return res;
    }
}