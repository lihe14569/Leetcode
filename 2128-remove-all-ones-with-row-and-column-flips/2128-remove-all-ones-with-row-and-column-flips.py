class Solution:
    def removeOnes(self, grid: List[List[int]]) -> bool:
        m, n = len(grid), len(grid[0])
        
        row1 = grid[0]
        rev_row1 = [1 - x for x in grid[0]]
        for i in range(1, m):
            if row1 != grid[i] and rev_row1 != grid[i]:
                return False
        return True