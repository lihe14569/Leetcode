class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Comparator<int[]> cmp = new Comparator<>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                long dis1 = p1[0] * p1[0] + p1[1] * p1[1];
                long dis2 = p2[0] * p2[0] + p2[1] * p2[1];
                if(dis1 == dis2) return 0;
                else if(dis1 < dis2) return -1;
                else return 1;
            }
        };
        Arrays.sort(points, cmp);
        return Arrays.copyOf(points, k);
    }
}