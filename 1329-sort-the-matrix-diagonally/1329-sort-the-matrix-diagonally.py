class Solution:
    def diagonalSort(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        
        def sort(row, col):
            diagonal = []
            diagonal_len = min(m - row, n - col)
            
            for i in range(diagonal_len):
                diagonal.append(mat[row + i][col + i])
            
            heapq.heapify(diagonal)
            
            for i in range(diagonal_len):
                mat[row + i][col + i] = heapq.heappop(diagonal)
            
        for i in range(m):
            sort(i, 0)
        for i in range(n):
            sort(0, i)
        
        return mat