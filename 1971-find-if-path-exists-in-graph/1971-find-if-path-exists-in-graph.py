class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        if source == destination:
            return True
        graph = defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        
        q = deque([source])
        seen = {source}
        
        while q:
            curr = q.popleft()
            if curr == destination:
                return True
            for nei in graph[curr]:
                if nei not in seen:
                    seen.add(nei)
                    q.append(nei)
        return False