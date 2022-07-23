class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] block = new boolean[9][10];
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    int bi = 3* (i / 3) + j /3;
                    int num = board[i][j] - '0';
                    row[i][num] = true;
                    col[j][num] = true;
                    block[bi][num] = true;
                }
            }
        }
        fill(0, 0, row, col, block, board);
    }
    
    public boolean fill(int r, int c, boolean[][] row, boolean[][] col, boolean[][] block, char[][] board) {
        if(r == 9) return true;
        int nc = (c + 1) % 9;
        int nr = nc == 0 ? r + 1 : r;
        if(board[r][c] != '.') return fill(nr, nc, row, col, block, board);
        for(int i = 1; i <= 9; i++) {
            int bi = 3 * (r / 3) + c / 3;
            if(!row[r][i] && !col[c][i] && !block[bi][i]) {
                row[r][i] = true;
                col[c][i] = true;
                block[bi][i] = true;
                board[r][c] = (char)(i + '0');
                if(fill(nr, nc, row, col, block, board)) return true;
                row[r][i] = false;
                col[c][i] = false;
                block[bi][i] = false;
                board[r][c] = '.';
            }
        }
        return false;
    }
}