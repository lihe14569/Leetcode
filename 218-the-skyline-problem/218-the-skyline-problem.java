class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        for(int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        Collections.sort(heights, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        int preMax = 0;
        for(int[] h : heights) {
            if(h[1] < 0) pq.offer(-h[1]);
            else pq.remove(h[1]);
            int currMax = pq.isEmpty() ? 0 : pq.peek();
            if(currMax != preMax) {
                res.add(Arrays.asList(h[0], currMax));
                preMax = currMax;
            }
        }
        return res;
    }
}