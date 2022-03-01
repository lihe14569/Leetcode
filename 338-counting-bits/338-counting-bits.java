class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            res[i] = count(i);
        }
        return res;
    }
    
    public int count(int i) {
        int count = 0;
        while(i != 0) {
            i &= i - 1;
            count++;
        }
        return count;
    }
}