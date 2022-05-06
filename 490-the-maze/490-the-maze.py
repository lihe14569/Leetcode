class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m, n, stopped= len(maze), len(maze[0]), set()
        
        def dfs(x, y):
            if (x,y) in stopped:
                return False
            stopped.add((x, y))
            if[x, y] == destination:
                return True
            for i, j in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                nx, ny = x ,y
                while 0 <= nx + i < m and 0 <= ny + j < n and maze[nx + i][ny + j] != 1:
                    nx += i
                    ny += j
                if dfs(nx, ny):
                    return True
            return False
        return dfs(*start)
            
            
            