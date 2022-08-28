class Solution:
    def diagonalSort(self, mat: List[List[int]]) -> List[List[int]]:
        m, n = len(mat), len(mat[0])
        
        diagonal = defaultdict(list)
        for i in range(m):
            for j in range(n):
                diagonal[i - j].append(mat[i][j])
        
        for lst in diagonal.values():
            heapq.heapify(lst)
        
        for i in range(m):
            for j in range(n):
                mat[i][j] = heapq.heappop(diagonal[i - j])
        return mat
        