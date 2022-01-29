class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int end = -1;
        for(int[] interval : intervals) {
            if(interval[0] < end)
                return false;
            end = interval[1];
        }
        return true;
    }
}