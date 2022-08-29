class Solution {
    public int[][] intervalIntersection(int[][] fl, int[][] sl) {
        Arrays.sort(fl, (a, b) -> a[0] - b[0]);
        Arrays.sort(sl, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while(i < fl.length && j < sl.length) {
            int start = Math.max(fl[i][0], sl[j][0]);
            int end = Math.min(fl[i][1], sl[j][1]);
            if(end - start >= 0) {
                res.add(new int[]{start, end});
            }
            if(fl[i][1] < sl[j][1]) i++;
            else j++;
        }
        return res.toArray(new int[res.size()][2]);
    }
}