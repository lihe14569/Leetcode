class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int s : stones) pq.offer(s);
        
        while(pq.size() >= 2) {
           int first = pq.poll();
            int second = pq.poll();

            if(first > second) {
                pq.offer(first - second);
            } 
            if(pq.isEmpty()) return 0; 
        }
            
        return pq.poll();
    }
}