class Solution {
    public int maxBoxesInWarehouse(int[] b, int[] wh) {
        for(int i = 1; i < wh.length; i++) {
            wh[i] = Math.min(wh[i], wh[i - 1]);
        }
        Arrays.sort(b);
        int cnt = 0;
        for(int i = wh.length - 1; i >= 0; i--) {
            if(cnt < b.length && b[cnt] <= wh[i])
                cnt++;
        }
        return cnt;
    }
}