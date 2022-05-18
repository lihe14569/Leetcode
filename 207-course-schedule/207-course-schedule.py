class Solution:
    def canFinish(self, n: int, prerequisites: List[List[int]]) -> bool:
        #build graph
        graph = defaultdict(list)
        indegree = [0]* n
        for u, v in prerequisites:
            graph[v].append(u)
            indegree[u] += 1
        q = deque()
        for i in range(n):
            if indegree[i] == 0:
                q.append(i)
        cnt = 0
        while q:
            curr = q.popleft()
            cnt += 1
            for nei in graph[curr]:
                indegree[nei] -= 1
                if indegree[nei] == 0:
                    q.append(nei)
        return cnt == n