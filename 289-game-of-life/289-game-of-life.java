class Solution {
    int live = 3;
    int dead = 2;
    public void gameOfLife(int[][] board) {
        if(board == null || board[0].length == 0) return;
        
        int m = board.length, n = board[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int around = findLive(board, i, j);
                if(board[i][j] == 0 && around == 3) {
                    board[i][j] = live;
                }
                else if(board[i][j] == 1) {
                    if(around >=2 && around <= 3)
                        continue;
                    else
                        board[i][j] = dead;
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == live)
                    board[i][j] = 1;
                else if(board[i][j] == dead)
                    board[i][j] = 0;
            }
        }
    }
    private int findLive(int[][] board, int i, int j) {
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int cnt = 0;
        for(int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                if(board[x][y] == 1 || board[x][y] == dead) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}