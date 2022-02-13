class Solution {
    public int minimumOperations(int[] nums) {
        List<Integer> even = new ArrayList<>(), odd = new ArrayList<>();
        Map<Integer, Integer> emap = new HashMap<>(), omap = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(i%2 == 0) emap.put(nums[i], emap.getOrDefault(nums[i], 0) + 1);
            else omap.put(nums[i], omap.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> epq = new PriorityQueue<>((a, b) ->  emap.get(b) - emap.get(a));
        PriorityQueue<Integer> opq = new PriorityQueue<>((a, b) ->  omap.get(b) - omap.get(a));
        epq.addAll(emap.keySet());
        opq.addAll(omap.keySet());
        
        while(!epq.isEmpty() && !opq.isEmpty()) {
            if(epq.peek() != opq.peek()) {
                return nums.length - emap.get(epq.peek()) - omap.get(opq.peek());
            }
            if(emap.get(epq.peek()) > omap.get(opq.peek())) opq.poll();
            else epq.poll();
        }
        int n = nums.length;
        int ecnt =  n /2;
        int ocnt = n % 2 == 0 ?  n / 2 :  n / 2 + 1;
        int eval = epq.isEmpty()? ecnt : ecnt - emap.get(epq.peek());
        int oval = opq.isEmpty()? ocnt : ocnt - omap.get(opq.peek());
        return eval + oval;
    }
}