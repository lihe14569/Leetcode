class Solution {
    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - a[1] - (b[0] - b[1]));
        for(int[] cost : costs) {
            pq.offer(cost);
        }
        int n = costs.length;
        int res = 0;
        for(int i = 0; i < n / 2; i++) {
            res += pq.poll()[0];
        }
        for(int i = 0; i < n / 2; i++) {
            res += pq.poll()[1];
        }
        return res;
    }
}