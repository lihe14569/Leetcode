class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0, n = timeSeries.length;
        int end = 0;
        for(int i = 0; i < n; i++) {
            int currEnd = timeSeries[i] + duration;
            if(timeSeries[i] <= end) {
                res += currEnd - end;
            } else {
                res += duration;
            }
            end = timeSeries[i] + duration;
        }
        return res;
    }
}