class Solution {
    public int numSteps(String s) {
        int res = 0, carry = 0;
        for(int i = s.length() - 1; i > 0; i--) {
            if(s.charAt(i) - '0' + carry == 1) {
                carry = 1;
                res += 2;
            } else {
                res++;
            }
        }
        return res + carry;
    }
}