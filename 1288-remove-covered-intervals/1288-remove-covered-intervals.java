class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int cnt = 0;
        Arrays.sort(intervals, (a, b) -> a[0]==b[0] ? b[1] - a[1] : a[0] - b[0]);
        int start = intervals[0][0], end = intervals[0][1];
        for(int i = 1; i < intervals.length ; i++) {
            if(end >= intervals[i][1]) {
                cnt++;
            } else {
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        return intervals.length - cnt;
    }
}