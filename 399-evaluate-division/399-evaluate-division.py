class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        graph = defaultdict(defaultdict)
        def dfs(curr_node, target_node, path, visited):
            visited.add(curr_node)
            ret = -1.0
            neighbours = graph[curr_node]
            if target_node in neighbours:
                ret = path * neighbours[target_node]
            else:
                for node, val in neighbours.items():
                    if node in visited: continue
                    ret = dfs(node, target_node, path * val, visited)
                    if ret != -1.0:
                        break
            visited.remove(curr_node)
            return ret
        result = []
        #build graph
        for (division, divisor), value in zip(equations, values):
            graph[division][divisor] = value
            graph[divisor][division] = 1 / value
        #check the path
        for division, divisor in queries:
            if division not in graph or divisor not in graph:
                ret = -1.0
            elif division == divisor:
                ret = 1.0
            else:
                visited = set()
                ret = dfs(division, divisor, 1, visited)
            result.append(ret)
        return result
            