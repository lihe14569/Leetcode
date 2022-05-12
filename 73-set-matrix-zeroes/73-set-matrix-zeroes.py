class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        
        """
        m, n = len(matrix), len(matrix[0])
        zeros = set()
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    zeros.add((i, j))
        
        for r, c in zeros:
            def makeZero(r, c):
                for i in range(0, m):
                    matrix[i][c] = 0
                for i in range(0, n):
                    matrix[r][i] = 0
            makeZero(r, c)
        