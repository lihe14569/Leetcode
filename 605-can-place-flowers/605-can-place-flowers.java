class Solution {
    public boolean canPlaceFlowers(int[] f, int n) {
        int N = f.length;
        int res = 0;
        for(int i = 0; i < N; i++) {
            if(f[i] == 0 && (i==0  || f[i - 1] == 0) && (i == N - 1 || f[i + 1] == 0)) {
                res++;
                f[i] = 1;
            }
        }
        return res >= n;
    }
}