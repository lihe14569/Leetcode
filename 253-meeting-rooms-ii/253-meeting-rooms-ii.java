class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n], end = new int[n];
        for(int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int j = 0; //j represent end index
        int cnt = 0, res = 0;
        for(int i = 0; i < n; i++) {
            if(start[i] < end[j]) {
                cnt++;
                res = Math.max(res, cnt);
            } else {
                j++;
            }
        }
        
        return res;
    }
}