class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];//0: unvisited 1: blue -1: red
        for(int i = 0 ; i < n; i++) {
            if(color[i] == 0 && !dfs(graph, color, i, 1)) return false;
        }
        return true;
    }
    public boolean dfs(int[][] graph, int[] color, int node, int c) {
        if(color[node] != 0) return color[node] == c;
        color[node] = c;
        for(int nei :graph[node]) {
            if(!dfs(graph, color, nei, -c)) return false;
        }
        return true;
    }
}