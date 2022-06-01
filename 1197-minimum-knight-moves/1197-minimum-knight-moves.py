class Solution:
    def minKnightMoves(self, x: int, y: int) -> int:
        #bfs
        seen = set()
        seen.add((0, 0))
        q = deque([(0, 0 , 0)])
        step = 0
        while q:
            size = len(q)
            for i in range(size):
                r, c, dis = q.popleft()
                if r == x and c == y:
                    return dis
                for i, j in (r + 2, c + 1), (r + 2, c - 1), (r + 1, c + 2), (r + 1, c - 2), (r -1, c + 2), (r -1, c- 2), (r- 2, c + 1), (r -2, c - 1):
                    if (i, j) not in seen:
                        seen.add((i, j))
                        q.append([i, j, dis + 1])
            
        return -1