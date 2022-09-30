class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < pid.size(); i++) {
            map.putIfAbsent(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(kill);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i< size; i++) {
                int node = q.poll();
                res.add(node);
                if(map.containsKey(node)) {
                    for(int nei : map.get(node)) {
                        q.offer(nei);
                    }   
                }
                
            }
        }
        return res;
    }
}