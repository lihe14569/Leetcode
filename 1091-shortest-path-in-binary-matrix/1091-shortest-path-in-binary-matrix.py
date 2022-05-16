class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        n = len(grid)
        if grid[0][0] == 1 or grid[n- 1][n - 1] == 1:
            return -1
        q=deque([(0, 0)])
        seen = set()
        seen.add((0, 0))
        dis = 1
        while q:
            size = len(q)
            for i in range(size):
                r, c = q.popleft()
                if r == n - 1 and c == n - 1:
                    return dis
                for x, y in (1, 0), (1, -1),(0, -1), (-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1):        
                    nr, nc = r + x, c + y
                    if nr >= 0 and nr < n and nc >= 0 and nc < n and grid[nr][nc]== 0 and  (nr, nc) not in seen:
                        q.append((nr, nc))
                        seen.add((nr, nc))
            dis += 1
        return -1
        