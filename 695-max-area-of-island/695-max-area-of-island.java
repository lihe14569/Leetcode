class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res  = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] seen = new boolean[m][n];
        
        for(int i = 0;i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !seen[i][j]) {
                    res = Math.max(res, dfs(grid, i, j, seen));
                }
            }
        }
        return res;
    }
    public int dfs(int[][] grid, int i, int j, boolean[][] seen) {
        int m = grid.length, n = grid[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || seen[i][j]) return 0;
        seen[i][j] = true;
        return 1 + dfs(grid, i + 1, j, seen) + dfs(grid, i, j + 1, seen) + dfs(grid, i - 1, j, seen) + dfs(grid, i, j - 1, seen);
    }
}