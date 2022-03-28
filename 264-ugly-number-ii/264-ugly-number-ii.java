class Solution {
    public int nthUglyNumber(int n) {
        int ugly = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        pq.offer(1L);
        set.add(1L);
        int[] primes = new int[]{2, 3, 5};
        for(int i = 0; i < n; i++) {
            long num = pq.poll();
            ugly = (int) num;
            for(int prime : primes) {
                long newUgly = prime * num;
                if(set.add(newUgly))
                    pq.offer(newUgly);
            }
        }
        return ugly;
    }
}