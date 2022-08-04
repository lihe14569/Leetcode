class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int l = 0, r = n - 1;
        while(l < r) {
            res[l++] = n;
            res[r--] = -n;
            n--;
        }
        return res;
    }
}