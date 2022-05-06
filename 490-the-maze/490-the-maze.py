class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        #bfs
        m, n = len(maze), len(maze[0])
        
        q = deque([tuple(start)])
        visited = set()
        destination = tuple(destination)
        visited.add(tuple(start))
        
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if curr == destination:
                    return True
                for x, y in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                    r, c = curr[0], curr[1]
                    while 0 <= r +x < m and 0 <= c + y < n and maze[r + x][c + y]!= 1:
                        r += x
                        c += y
                    if (r,c) not in visited:
                        q.append((r, c))
                        visited.add((r,c))
        return False
                        