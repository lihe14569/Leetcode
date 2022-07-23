class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length, n = board[0].length;
        Set<Character> seen = new HashSet<>();
        
        //check row
        for(int i = 0; i < m; i++) {
            seen.clear();
            for(int j = 0; j < n; j++) {
                if(board[i][j] != '.') {
                    if(seen.contains(board[i][j])) return false;
                    seen.add(board[i][j]);
                }
            }
        }
        
        //check column
        for(int i = 0; i < m; i++) {
            seen.clear();
            for(int j = 0; j < n; j++) {
                if(board[j][i] != '.') {
                    if(seen.contains(board[j][i])) return false;
                    seen.add(board[j][i]);
                }
            }
        }
        
        //check block
        for(int i = 0; i < m; i += 3) {
            for(int j = 0; j < n; j+= 3) {
                seen.clear();
                for(int x = 0; x < 3; x++) {
                    for(int y = 0; y < 3; y++) {
                        if(board[i + x][j + y] != '.') {
                            if(seen.contains(board[i + x][j + y])) return false;
                            seen.add(board[i + x][j + y]);
                        }
                    }
                }
            }
        }
        
        return true;
    }
}