class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] seen = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dfs(board, seen, i, j, 0, word)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, boolean[][] seen, int i, int j, int idx, String word) {
        if(idx == word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || seen[i][j] || board[i][j] != word.charAt(idx)) return false;
        seen[i][j] = true;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if(dfs(board, seen, x, y, idx + 1, word)) return true;
        }
        seen[i][j] = false;
        return false;
    }
}