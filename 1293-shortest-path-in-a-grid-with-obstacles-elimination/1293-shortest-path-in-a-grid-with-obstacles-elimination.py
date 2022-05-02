class Solution:
    def shortestPath(self, grid: List[List[int]], k: int) -> int:
        row, col = len(grid), len(grid[0])
        
        if k >= row + col - 2: return row + col - 2
        q = collections.deque()
        start = (0, 0 , k)
        seen = set([start])
        q.append((0, start))
        
        while q:
            steps, (r, c, k) = q.popleft()
            if r == row - 1 and c == col - 1:
                return steps
            for x, y in [(r + 1, c), (r - 1, c), (r, c + 1), (r, c - 1)]:
                if 0 <= x < row and 0 <= y < col:
                    remaining = k - grid[x][y]
                    new_state = (x, y, remaining)
                    if remaining >= 0 and new_state not in seen:
                        seen.add(new_state)
                        q.append((steps + 1, new_state))
        return -1
                    