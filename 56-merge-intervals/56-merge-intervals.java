class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if(intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] curr = intervals[0];
        res.add(curr);
        
        for(int[] interval : intervals) {
            if(curr[1] >= interval[0]) {
                curr[1] = Math.max(curr[1], interval[1]);
            } else {
                curr = interval;
                res.add(curr);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}