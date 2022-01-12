class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //----          -----
        //  ---------         ------
        //      --------
        int m = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int end = Integer.MIN_VALUE, cnt = 0;
        for(int[] interval : intervals) {
            if(interval[0] < end) 
                cnt++;
            else end = interval[1];
        }
        return cnt;
    }
}