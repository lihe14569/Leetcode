class Solution:
    def minKnightMoves(self, x: int, y: int) -> int:

        cache = {}
        def dfs(x, y):
            nonlocal cache
            if x + y == 0:
                # base case: (0, 0)
                return 0
            elif x + y == 2:
                # base case: (1, 1), (0, 2), (2, 0)
                return 2
            elif (x, y) in cache:
                return cache[(x, y)]
            else:
                cache[(x, y)] = min(dfs(abs(x - 1), abs(y - 2)), dfs(abs(x - 2), abs(y - 1))) + 1
                return cache[(x, y)]
                

        return dfs(abs(x), abs(y))