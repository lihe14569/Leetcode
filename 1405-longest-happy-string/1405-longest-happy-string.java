class Solution {
    class Pair {
        char c;
        int val;
        public Pair(char c, int val) {
            this.c = c;
            this.val = val;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.val - x.val);
        if(a > 0) pq.offer(new Pair('a', a));
        if(b > 0) pq.offer(new Pair('b', b));
        if(c > 0) pq.offer(new Pair('c', c));
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Pair first = pq.poll();
            for(int i = 0; i < 2 && first.val > 0; i++) {
                sb.append(first.c);
                first.val--;
            }
            if(pq.isEmpty()) break;
            Pair second = pq.poll();
            if(second.val > 1 && second.val > first.val) {
                sb.append(second.c);
                sb.append(second.c);
                second.val -= 2;
            } else if(second.val > 0) {
                sb.append(second.c);
                second.val--;
            }
            if(first.val > 0) pq.offer(first);
            if(second.val > 0) pq.offer(second);
        }
        return sb.toString();
    }
}