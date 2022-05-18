class Solution:
    graph = defaultdict(list)
    rank = {}
    edges = set()
    
    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        self.buildGraph(n, connections)
        self.dfs(0, 0)
        return list(self.edges)
    def buildGraph(self, n: int, connections: List[List[int]]):
        self.graph = defaultdict(list)
        self.rank = {}
        self.edges = set()
        
        for i in range(n):
            self.rank[i] = None
        
        for u, v in connections:
            self.graph[u].append(v)
            self.graph[v].append(u)
            self.edges.add((min(u, v), max(u, v)))
    
    def dfs(self, node: int, rank: int) -> int:
        if self.rank[node]:
            return self.rank[node]
        self.rank[node] = rank
        min_rank = rank + 1
        for n in self.graph[node]:
            if self.rank[n] and self.rank[n] == rank - 1:
                continue
            r_rank = self.dfs(n, rank + 1)
            if r_rank <= rank:
                self.edges.remove((min(node, n), max(node, n)))
            min_rank = min(min_rank, r_rank)
        return min_rank
    