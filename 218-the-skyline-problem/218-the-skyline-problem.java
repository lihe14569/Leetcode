class Solution {
    public List<List<Integer>> getSkyline(int[][] bs) {
        List<int[]> lines = new ArrayList<>();
        for(int[] b : bs) {
            lines.add(new int[]{b[0], -b[2]});
            lines.add(new int[]{b[1], b[2]});
        }
        Collections.sort(lines, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(0);
        int preMax = 0;
        List<List<Integer>> res = new ArrayList<>();
        for(int[] b : lines) {
            if(b[1] < 0)
                pq.offer(-b[1]);
            else
                pq.remove(b[1]);
            int currMax = pq.peek();
            if(currMax != preMax) {
                res.add(List.of(b[0], currMax));
                preMax = currMax;
            }
        }
        return res;
    }
}