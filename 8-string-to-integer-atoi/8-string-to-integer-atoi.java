class Solution {
    public int myAtoi(String s) {
        //1.ignore whiltespace
        if(s ==null || s.length() == 0) return 0;
        int i = 0;
        int sign = 1;
        while(i < s.length() && s.charAt(i) == ' ' ) i++;
        //2.check positive/negative
        if(i < s.length() && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if(i < s.length() && s.charAt(i) == '+') {
            i++;
        }
                                                  
        //3.read next character until non-digit character reached
        int num = 0;
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int curr = s.charAt(i) - '0';
             //4.if overflow, clamp to in range
            if(num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && curr > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + curr;
            i++;
        }
        
        //5.return value
        return sign * num;
    }
}