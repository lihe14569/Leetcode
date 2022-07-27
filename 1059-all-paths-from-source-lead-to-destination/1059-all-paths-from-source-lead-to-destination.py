class Solution:
    def leadsToDestination(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        graph = self.buildGraph(edges)
        seen = [0] * n
        return self.dfs(graph, source, destination, seen)
    
    def dfs(self, graph, source, destination, seen):
        #base case
        if source not in graph:
            return source == destination
        seen[source] = 1
        for next in graph[source]:
            if seen[next] == 1: return False
            if seen[next] == 0 and not self.dfs(graph, next, destination, seen): return False
        seen[source] = 2
        return True
        
    def buildGraph(self, edges):
        graph = defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
        return graph