class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def createBoard(state):
            board = []
            for row in state:
                board.append(''.join(row))
            return board
        
        def backtrack(row, cols, diagonals, anti_diagonals, state):
            #base case
            if row == n:
                ans.append(createBoard(state))
                return
            for col in range(n):
                diagonal = row - col
                anti_diagonal = row + col
                if col in cols or diagonal in diagonals or anti_diagonal in anti_diagonals:
                    continue
                cols.add(col)
                diagonals.add(diagonal)
                anti_diagonals.add(anti_diagonal)
                state[row][col] = 'Q'
                backtrack(row + 1, cols, diagonals, anti_diagonals, state)
                cols.remove(col)
                diagonals.remove(diagonal)
                anti_diagonals.remove(anti_diagonal)
                state[row][col] = '.'
        ans = []
        state = [['.']*n for _ in range(n)]
        backtrack(0, set(), set(), set(), state)
        return ans