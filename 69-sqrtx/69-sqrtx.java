class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x== 1) return x;
        int l = 1, r = x;
        while(l < r) {
            int m = l + (r - l + 1) / 2;
            if(m <= x / m) {
                 l = m;
            } else {
                r = m - 1;
            }
        }
        if(l * l > x) l--;
        return l;
    }
}