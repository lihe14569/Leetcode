class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
       
        for(int[] interval : intervals) {
            if(res.size() == 0 || interval[0] > res.get(res.size() - 1)[1]) {
                res.add(interval);
            } else {
                int end = res.get(res.size() - 1)[1];
                res.get(res.size() - 1)[1] = Math.max(end, interval[1]);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}