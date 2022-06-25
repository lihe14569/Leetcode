class Solution {
    public int[][] intervalIntersection(int[][] fl, int[][] sl) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(fl, (a, b) -> a[0] - b[0]);
        Arrays.sort(sl, (a, b) -> a[0] - b[0]);
        
        int p1 = 0, p2 = 0;
        while(p1 < fl.length && p2 < sl.length) {
            int[] s1 = fl[p1];
            int[] s2 = sl[p2];
            int l = Math.max(s1[0], s2[0]);
            int r = Math.min(s1[1], s2[1]);
            if(r - l >= 0) {
                res.add(new int[]{l, r});
            }
            if(s1[1] < s2[1]) 
                p1++;
            else
                p2++;
        }
        return res.toArray(new int[res.size()][2]);
    }
}