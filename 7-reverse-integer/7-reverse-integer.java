class Solution {
    public int reverse(int x) {
        long res = 0;
        while(x != 0) {
            if(res > 0 && res > (Integer.MAX_VALUE - x % 10) / 10) return 0;
            if(res < 0 && res < (Integer.MIN_VALUE - x % 10) / 10) return 0;
            res = res* 10 + x % 10;
            x /= 10;
        }
        return (int) res;
    }
}