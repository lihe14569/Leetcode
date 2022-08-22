class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //bfs topological sort
        //建图
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];
        //建图+创建入度
        for(int[] course : prerequisites) {
            int end = course[0], start = course[1];
            graph.computeIfAbsent(start, x -> new ArrayList<>()).add(end);
            inDegree[end]++;
        }
        //将入度为零的source放入q, 进行bfs
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++) { //index是node,indegree里面存的node的入度，不要搞混
            if(inDegree[i] == 0)
                q.offer(i);
        }
        int cnt = 0; //cnt 来记录入度为零的点
        while(!q.isEmpty()) {
            int curr = q.poll();
            cnt++;
            if(graph.containsKey(curr)) {
                for(int nei : graph.get(curr)) {
                    inDegree[nei]--;
                    if(inDegree[nei] == 0)
                        q.offer(nei);
                }
            }
        }
        return cnt == numCourses;
    }
}