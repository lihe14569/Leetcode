class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def backtrack(row, cs, ds, ads, state):
            nonlocal res
            #base case
            if row == n:
                lst= []
                for s in state:
                    lst.append(''.join(s))
                res.append(lst)
                return 
            for c in range(n):
                d = row + c
                ad = row - c
                if c in cs or d in ds or ad in ads:
                    continue
                cs.add(c)
                ds.add(d)
                ads.add(ad)
                state[row][c] = 'Q'
                backtrack(row + 1, cs, ds, ads, state)
                cs.remove(c)
                ds.remove(d)
                ads.remove(ad)
                state[row][c] = '.'
        #create a board
        board = [['.']*n for _ in range(n)]
        res = []
        backtrack(0, set(), set(), set(), board)
        return res
        