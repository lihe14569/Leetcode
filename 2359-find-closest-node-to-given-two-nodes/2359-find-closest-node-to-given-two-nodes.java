class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] m1 = new int[n];
        int[] m2 = new int[n];
        Arrays.fill(m1, -1);
        Arrays.fill(m2, -1);
        dfs(node1, 0, edges, m1);
        dfs(node2, 0, edges, m2);
        
        int minDist = Integer.MAX_VALUE;
        int res = -1;
        for(int i = 0; i < n; i++) {
            if(m1[i] >= 0 && m2[i] >= 0 && Math.max(m1[i], m2[i]) < minDist) {
                minDist = Math.max(m1[i], m2[i]);
                res = i;
            }
        }
        return res;
    }
    public void dfs(int node, int dist, int[] e, int[] memo) {
        
        if(node != -1 && memo[node] == -1) {
            memo[node] = dist;
            dfs(e[node], dist + 1, e, memo);
        }
    }
}