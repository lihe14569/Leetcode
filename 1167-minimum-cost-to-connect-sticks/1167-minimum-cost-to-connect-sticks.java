class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : sticks) pq.offer(s);
        int res = 0;
        while(pq.size() > 1) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            int cost = s1 + s2;
            res += cost;
            pq.offer(cost);
        }
        return res;
    }
}