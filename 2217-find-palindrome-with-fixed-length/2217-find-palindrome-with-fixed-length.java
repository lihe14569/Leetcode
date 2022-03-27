class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int len = (intLength + 1) / 2;
        long[] res = new long[queries.length];
        int i = 0;
        long start = (long) Math.pow(10, len - 1), end =(long) Math.pow(10, len) - 1;
        long power = (long) Math.pow(10, intLength / 2);
        for(int q : queries) {
            res[i++] = start + q  - 1 > end ? -1 : (start + q - 1) * power + reverse(start+ q -1, intLength % 2);
        }
        return res;
    }
    public long reverse(long num, int skip) {
        if(skip == 1) num /= 10;
        long res = 0;
        while(num != 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        return res;
    }
}