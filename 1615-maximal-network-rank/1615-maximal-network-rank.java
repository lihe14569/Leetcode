class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] graph = new int[n];
        boolean[][] connected = new boolean[n][n];
        for(int[] e : roads) {
            graph[e[0]] += 1;
            graph[e[1]] += 1;
            connected[e[0]][e[1]] = true; 
            connected[e[1]][e[0]] = true; 
        }
        
        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j =  i+ 1; j < n; j++) {
                res = Math.max(res, graph[i] + graph[j] -(connected[i][j] ? 1 : 0));
            }
        }
        return res;
    }
}