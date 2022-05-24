class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        self.m, self.n = len(matrix), len(matrix[0])
        
        self.ps = [[0] * (self.n + 1) for i in range(self.m + 1)]
        for i in range(1, self.m + 1):
            for j in range(1, self.n + 1):
                self.ps[i][j] = self.ps[i- 1][j] + self.ps[i][j - 1] + matrix[i - 1][j - 1] - self.ps[i - 1][j - 1]
                

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        return self.ps[row2 + 1][col2 + 1] - self.ps[row2 + 1][col1] - self.ps[row1][col2 + 1] + self.ps[row1][col1]


# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)