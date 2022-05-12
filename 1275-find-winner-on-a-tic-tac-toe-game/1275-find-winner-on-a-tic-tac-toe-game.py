class Solution:
    def tictactoe(self, moves: List[List[int]]) -> str:
        
        n = 3
        
        row, col = [0]* n, [0]* n
        diag, anti_diag = 0, 0
        
        for i, (r, c) in enumerate(moves):
            player = 1 if i % 2 == 0 else -1
            row[r] += player
            col[c] += player
            if r == c: diag += player
            if r + c == n - 1: anti_diag += player
            if abs(row[r]) == n or abs(col[c]) == n or abs(diag) == n or abs(anti_diag) == n:
                return 'A' if player== 1 else 'B'
            
        return 'Draw' if len(moves) == n * n else 'Pending'
                
                
            
                