class Solution:
    def pacificAtlantic(self, h: List[List[int]]) -> List[List[int]]:
        m, n = len(h), len(h[0])
        pr, ar = set(), set()
        
        def dfs(i, j, reach):
            reach.add((i, j))
            for x, y in [(1, 0), (0, 1), (-1, 0), (0, -1)]:
                r = i + x
                c = j + y
                if r < 0 or r >= m or c < 0 or c >= n:
                    continue
                if (r, c) in reach:
                    continue
                if h[r][c] < h[i][j]:
                    continue
                dfs(r, c, reach)
        for i in range(m):
            dfs(i, 0, pr)
            dfs(i, n - 1, ar)
        for i in range(n):
            dfs(0, i, pr)
            dfs(m - 1, i, ar)
        return pr.intersection(ar)