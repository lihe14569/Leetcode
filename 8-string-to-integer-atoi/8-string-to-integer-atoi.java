class Solution {
    public int myAtoi(String s) {
        int i = 0;
        while(i < s.length() && s.charAt(i) == ' ') i++;
        int neg = 1;
        if(i < s.length() && s.charAt(i) == '-') {
            neg = -1;
            i++;
        } else if(i < s.length() && s.charAt(i) == '+') {
            neg = 1;
            i++;
        }
    
        int res = 0;
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int x = s.charAt(i) - '0';
            if(neg > 0 && res > (Integer.MAX_VALUE - x) / 10) return Integer.MAX_VALUE;
            if(neg < 0 && -res < (Integer.MIN_VALUE + x) / 10) return Integer.MIN_VALUE;
            if(-res * 10 - x == Integer.MIN_VALUE) return Integer.MIN_VALUE;
            res  = res * 10 + x;
            i++;
            if(res > Integer.MAX_VALUE) break;
        }
        res = res * neg;
        if(res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return res;
    }
}