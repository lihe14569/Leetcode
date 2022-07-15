class Solution {
    int[][] dirs = new int[][] {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    
    public int maxAreaOfIsland(int[][] grid) {
        //dfs
        int m = grid.length, n = grid[0].length;
        boolean[][] seen = new boolean[m][n];
        
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!seen[i][j]) {
                    res = Math.max(res, dfs(grid, i, j, seen));
                }
            }
        }
        return res;
    }
    
    public int dfs(int[][] grid, int i, int j, boolean[][] seen) {
        int m = grid.length, n = grid[0].length;
        if(i >= m || i < 0 || j >= n || j < 0 || seen[i][j] || grid[i][j] == 0) return 0;
        int count = 1;
        seen[i][j] = true;
        for(int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            count += dfs(grid, x, y, seen);
        }
        return count;
    }
}