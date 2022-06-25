class Solution {
    public boolean isPossible(int[] target) {
        if(target.length == 1) return target[0] == 1;
        PriorityQueue<Integer> pq =new PriorityQueue<>((a, b) -> b - a);
        long sum = 0;
        for(int num : target){
            pq.offer(num);
            sum += num;
        }
        
        while(pq.peek() != 1) {
            int a = pq.poll();
            long others = sum - a;
            if(others == 0 || a <= others) return false;
            long b = a % others;
            if(b == 0) b = others;
            pq.offer((int)b);
            sum = others + b;
        }
        return true;
    }
}