class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        // 0 : unvisited, 1 : blue, -1: red
        int[] state = new int[n]; 
        
        for(int i = 0; i < n; i++) {
            if(state[i] == 0 &&!dfs(graph, i, state, 1))
                return false;
        }
        return true;
    }
    public boolean dfs(int[][] graph, int node, int[] state, int color) {
        if(state[node] != 0) return state[node] == color;
        state[node] = color;
        for(int nei : graph[node]) {
            if(!dfs(graph, nei, state, -color))
                return false;
        }
        return true;
    }
}
