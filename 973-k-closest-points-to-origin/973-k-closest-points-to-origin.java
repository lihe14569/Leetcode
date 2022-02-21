class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> distance(b) - distance(a));
        for(int[] p : points) {
            pq.offer(p);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        int i = 0;
        while(!pq.isEmpty()) {
            res[i++] = pq.poll();
        }
        return res;
    }
    public int distance(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}