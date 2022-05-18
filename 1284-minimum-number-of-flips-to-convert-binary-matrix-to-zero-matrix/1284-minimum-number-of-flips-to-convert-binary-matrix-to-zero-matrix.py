class Solution:
    def minFlips1(self, mat: List[List[int]]) -> int:
        m, n = len(mat), len(mat[0])
        num = sum(cell<<(i*n + j) for i, row in enumerate(mat) for j, cell in enumerate(row))
        q = deque()
        q.append(num)
        seen = set()
        seen.add(num)
        step = 0
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if curr == 0:
                    return step
                for x in range(m):
                    for y in range(n):
                        next = curr
                        for r, c in (x, y), (x + 1, y), (x -1, y), (x , y + 1), (x, y - 1):
                            if 0 <= r < m and 0 <= c < n:
                                next ^= 1<< (r*n + c)
                                if next not in seen:
                                    seen.add(next)
                                    q.append(next)
            step += 1
        return -1
    def minFlips(self, mat: List[List[int]]) -> int:
        m, n = len(mat), len(mat[0])
        start = sum(cell << (i * n + j) for i, row in enumerate(mat) for j, cell in enumerate(row))
        dq = collections.deque([(start, 0)])
        seen = {start}
        while dq:
            cur, step = dq.popleft()
            if not cur:
                return step
            for i in range(m):
                for j in range(n):
                    next = cur
                    for r, c in (i, j), (i, j + 1), (i, j - 1), (i + 1, j), (i - 1, j):
                        if m > r >= 0 <= c < n:
                            next ^= 1 << (r * n + c)
                    if next not in seen:
                        seen.add(next)
                        dq.append((next, step + 1))
        return -1
                            