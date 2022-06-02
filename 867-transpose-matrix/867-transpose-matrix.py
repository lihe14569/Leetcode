class Solution:
    def transpose(self, matrix: List[List[int]]) -> List[List[int]]:
        r, c = len(matrix), len(matrix[0])
        nMatrix = [[0]*r for _ in range(c)]
        for i in range(r):
            for j in range(c):
                nMatrix[j][i] = matrix[i][j]
        return nMatrix