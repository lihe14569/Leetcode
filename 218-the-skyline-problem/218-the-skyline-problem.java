class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> lines = new ArrayList<>();
        for(int[] b : buildings) {
            lines.add(new int[]{b[0], -b[2]});
            lines.add(new int[]{b[1], b[2]});
        }
        Collections.sort(lines, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b- a);
        int premax = 0;
        for(int[] b : lines) {
            if(b[1] < 0) pq.offer(-b[1]);
            else pq.remove(b[1]);
            int currmax = pq.isEmpty() ? 0 : pq.peek();
            if(currmax != premax) {
                res.add(List.of(b[0], currmax));
                premax = currmax;
            }
        }
        return res;
    }
}