class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //sort by the end
        int res = 0;
        Arrays.sort(intervals, (a, b) -> a[1]- b[1]);
        int end = Integer.MIN_VALUE;
        for(int[] interval : intervals) {
            if(interval[0] < end) {
                res++;
            } else {
                end = interval[1];
            }
        }
        return res;
    }
}