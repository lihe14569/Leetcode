class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        int[] inCount = new int[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] relation : relations) {
            map.computeIfAbsent(relation[0], k -> new ArrayList<>()).add(relation[1]);
            inCount[relation[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int semester = 0, studied = 0;
        for(int i = 1; i < n + 1; i++) {
            if(inCount[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                studied++;
                int currClass = q.poll();
                if(!map.containsKey(currClass)) continue;
                for(int nextClass : map.get(currClass)) {
                    inCount[nextClass]--;
                    if(inCount[nextClass] == 0) q.offer(nextClass);
                }
            }
            semester++;
        }
        return studied == n ? semester : -1;
    }
}