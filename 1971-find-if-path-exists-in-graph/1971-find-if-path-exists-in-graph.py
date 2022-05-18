class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        if source == destination:
            return True
        graph = defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        hasPath = False
        seen = set()
        def dfs(node):
            nonlocal hasPath
            if node in seen:
                return
            
            if node == destination:
                hasPath = True
            seen.add(node)
            for nei in graph[node]:
                dfs(nei)
        
        dfs(source)
        return hasPath
            