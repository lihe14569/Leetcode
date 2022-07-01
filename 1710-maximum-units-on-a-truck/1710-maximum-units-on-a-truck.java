class Solution {
    public int maximumUnits(int[][] bt, int tz) {
        Arrays.sort(bt, (a, b) -> (b[1] - a[1]));
        int cnt= 0;
        int i = 0;
        while(tz > 0 && i < bt.length) {
            if(bt[i][0] <= tz) {
                tz -= bt[i][0];
                cnt += bt[i][0] * bt[i][1];
            } else {
                cnt += tz * bt[i][1];
                tz = 0;
            }
            i++;
        }
        return cnt;
    }
}