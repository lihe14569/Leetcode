class Solution {
    public int getFood(char[][] grid) {
        //bfs
        int[] start = new int[2];
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '*') {
                    start = new int[]{i, j}; 
                    break;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[][] seen = new boolean[m][n];
        q.offer(start);
        seen[start[0]][start[1]] = true;
        int step = 0;
        int[][] dirs = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];
                if(grid[r][c] == '#') return step;
                
                for(int[] dir : dirs) {
                    int x = dir[0] + r;
                    int y = dir[1] + c;
                    if(x < 0 || x >= m || y < 0 || y >= n || seen[x][y] || grid[x][y] == 'X') continue;
                    q.offer(new int[]{x, y});
                    seen[x][y] = true;
                }
            }
            step++;
        }
        return -1;
    }
}