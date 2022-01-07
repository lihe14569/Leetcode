class Solution {
    public boolean isPalindrome(int x) {
        //判断特殊情况
        if(x < 0 || (x != 0 && x % 10 == 0)) return false;
        int reverse = 0;
        while(x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return (reverse == x) || (reverse / 10 == x);
    }
}