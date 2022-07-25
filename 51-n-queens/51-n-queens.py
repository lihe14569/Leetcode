class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        matrix = [['.'] * n for _ in range(n)]
        res = []
        def solve(row, col, diagonal, anti_diagonal, matrix):
            nonlocal res
            #base case
            if row == n:
                lst = []
                for c in matrix:
                    lst.append(''.join(c))
                res.append(lst)
                return
            
            for c in range(n):
                di = row + c
                adi = row - c
                if c in col or di in diagonal or adi in anti_diagonal:
                    continue
                col.add(c)
                diagonal.add(di)
                anti_diagonal.add(adi)
                matrix[row][c] = 'Q'
                solve(row + 1, col, diagonal, anti_diagonal, matrix)
                matrix[row][c] = '.'
                col.remove(c)
                diagonal.remove(di)
                anti_diagonal.remove(adi)
        solve(0, set(), set(), set(), matrix)
        return res