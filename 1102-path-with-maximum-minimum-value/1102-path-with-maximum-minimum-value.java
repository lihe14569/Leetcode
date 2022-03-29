class Solution {
    int[][] dirs= new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    public int maximumMinimumPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int left = 0, right = Math.min(grid[0][0], grid[m - 1][n - 1]);
        while(left < right) {
            int mid = (left + right + 1) / 2;
            if(pathExist(grid, mid))
                left = mid;
            else 
                right = mid - 1;
        }
        return left;
    }
    public boolean pathExist(int[][] grid, int target) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                if(curr[0] == m - 1 && curr[1] == n - 1) return true;
                
                for(int[] dir : dirs) {
                    int nx = curr[0] + dir[0];
                    int ny = curr[1] + dir[1];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] >= target && !visited[nx][ny]) {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return false;
    }
}