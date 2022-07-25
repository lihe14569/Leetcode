class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        matrix = [['.']*n for _ in range(n)]
        cs, ds, ads = set(), set(), set()
        res = []
        def solve(row): 
            if row == n:
                solution = []
                for col in matrix:
                    solution.append(''.join(col))
                res.append(solution)
                return
            
            for c in range(n):
                di = row + c
                adi = row - c
                if c in cs or di in ds or adi in ads:
                    continue
                matrix[row][c] = 'Q'
                cs.add(c)
                ds.add(di)
                ads.add(adi)
                solve(row + 1)
                matrix[row][c] = '.'
                cs.remove(c)
                ds.remove(di)
                ads.remove(adi)
        solve(0)
        return res