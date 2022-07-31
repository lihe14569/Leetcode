class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] m1 = new int[n];
        int[] m2 = new int[n];
        Arrays.fill(m1, -1);
        Arrays.fill(m2, -1);
        
        bfs(edges, node1, m1);
        bfs(edges, node2, m2);
        int minDis = Integer.MAX_VALUE;
        int res = -1;
        for(int i = 0; i < n; i++) {
            if(m1[i] >= 0 && m2[i] >= 0 && Math.max(m1[i], m2[i]) < minDis) {
                minDis = Math.max(m1[i], m2[i]);
                res = i;
            }
        }
        return res;
    }
    public void bfs(int[] edges, int node, int[] memo) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        Set<Integer> seen = new HashSet<>();
        int dis = 0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            memo[curr] = dis;
            seen.add(curr);
            int nei = edges[curr];
            if(nei != -1 && !seen.contains(nei)) {
                q.offer(nei); 
                dis++;
            } else break;
        }
    }
}