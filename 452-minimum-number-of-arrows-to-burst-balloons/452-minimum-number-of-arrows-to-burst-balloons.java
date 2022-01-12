class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int cnt = 1;
        int end = points[0][1];
        for(int[] p : points) {
            if(p[0] > end) {
                cnt++;
                end = p[1];
            } 
        }
        return cnt;
    }
}