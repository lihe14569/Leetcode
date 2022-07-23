class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] blk = new boolean[9][10];
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    int idx = board[i][j] - '0';
                    int bi = 3 * (i / 3) + j / 3;
                    row[i][idx] = true;
                    col[j][idx] = true;
                    blk[bi][idx] = true;
                }
            }
        }
        backtrack(0, 0, row, col, blk, board);
    }
    public boolean backtrack(int r, int c, boolean[][] row, boolean[][] col, boolean[][] blk, char[][] board) {
        if(r == 9) return true;
        int nc = (c + 1) % 9;
        int nr = nc == 0 ? r + 1 : r;
        
        if(board[r][c] != '.')  return backtrack(nr, nc, row, col, blk, board);
        
        for(int i = 1; i <= 9; i++) {
            int bi = 3 * (r / 3) + c / 3;
            
            if(!row[r][i] && !col[c][i] && !blk[bi][i]) {
                board[r][c] = (char)(i + '0');
                row[r][i] = true;
                col[c][i]= true;
                blk[bi][i] = true;
                if(backtrack(nr, nc, row, col, blk, board)) return true;
                board[r][c] = '.';
                row[r][i] = false;
                col[c][i] = false;
                blk[bi][i] = false;
            }
        }
        return false;
    }
}