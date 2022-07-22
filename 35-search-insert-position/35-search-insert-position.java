class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> block = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.' && !row.add(board[i][j]))
                    return false;
                if(board[j][i] != '.' && !col.add(board[j][i]))
                    return false;
                int x = 3*(i/3) + j/3;
                int y = 3*(i%3) + j%3;
                if(board[x][y] != '.' && !block.add(board[x][y]))
                    return false;
            }
        }
        return true;
    }
}