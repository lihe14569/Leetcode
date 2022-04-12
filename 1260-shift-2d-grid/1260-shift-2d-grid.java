class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        
        for(;k > 0; k--) {
            int[][] ngrid = new int[m][n];
            for(int i = 0; i < m ; i++) {
                for(int j = 1; j < n; j++) {
                    ngrid[i][j] = grid[i][j - 1];
                }
            }
            ngrid[0][0] = grid[m - 1][n  - 1];
            for(int i = 1; i < m; i++) ngrid[i][0] = grid[i - 1][n - 1];
            grid = ngrid;
        }
        List<List<Integer>> res= new ArrayList<>();
        for(int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                list.add(grid[i][j]);
            }
            res.add(list);
        }
        return res;
    }
}