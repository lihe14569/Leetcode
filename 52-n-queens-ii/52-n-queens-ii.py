class Solution:
    def totalNQueens(self, n: int) -> int:
        cs, ds, ads = set(), set(), set()
        def backtrack(row):
            if row == n:
                return 1
            solution = 0
            for c in range(n):
                di = row + c
                adi = row - c
                if c in cs or di in ds or adi in ads:
                    continue
                cs.add(c)
                ds.add(di)
                ads.add(adi)
                solution += backtrack(row + 1)
                cs.remove(c)
                ds.remove(di)
                ads.remove(adi)
            return solution
        
        return backtrack(0)