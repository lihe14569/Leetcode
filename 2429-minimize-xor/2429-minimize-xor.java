class Solution {
    public int minimizeXor(int num1, int num2) {
        int cnt = 0;
        while(num2 != 0) {
            cnt += num2 & 1;
            num2 >>= 1;
        }
        int res = 0;
        for(int i = 29; i >= 0 && cnt > 0; i--) {
            if(((num1 >> i) & 1) == 1) {
                res -= 1<< i;
                cnt--;
            }
        }
        for(int i = 0; i <= 29 && cnt > 0; i++) {
            if( ((num1 >> i) & 1) == 0) {
                res += 1 << i;
                cnt--;
            }
        }
        return (res + num1) ^ num1;
    }
}