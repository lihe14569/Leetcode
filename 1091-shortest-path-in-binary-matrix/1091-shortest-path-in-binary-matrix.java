class Solution {
    int[][] dirs = new int[][]{{1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        //corner
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        int[] start = new int[]{0, 0};
        int[] end = new int[]{n -1, n - 1};
        
        q.offer(start);
        visited[start[0]][start[1]] = true;
        int step  = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] node = q.poll();
                if(node[0] == end[0] && node[1] == end[1]) return step;
                for(int[] dir : dirs) {
                    int x = node[0] + dir[0];
                    int y = node[1] + dir[1];
                    if(x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || grid[x][y] == 1) continue;
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
            step++;
        }
        return -1;
    }
}