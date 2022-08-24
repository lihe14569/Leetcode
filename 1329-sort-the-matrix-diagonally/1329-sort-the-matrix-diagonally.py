class Solution:
    def diagonalSort(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        
        diagonals = defaultdict(list)
        
        for i in range(m):
            for j in range(n):
                diagonals[i - j].append(mat[i][j])
        
        for dia in diagonals.values():
            heapq.heapify(dia)
        
        for i in range(m):
            for j in range(n):
                mat[i][j] = heapq.heappop(diagonals[i - j])
        
        return mat