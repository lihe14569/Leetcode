class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int cnt = 1;
        int[] curr = intervals[0];

        for(int i = 1; i < intervals.length; i++) {
            if(curr[0] <= intervals[i][0] && curr[1] >= intervals[i][1])
                continue;
            cnt++;
            curr = intervals[i];
        }
        return cnt;
    }
}