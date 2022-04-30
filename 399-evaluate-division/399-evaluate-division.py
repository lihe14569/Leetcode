class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        graph = defaultdict(defaultdict)
        def dfs(curr_node, target_node, path, visited):
            visited.add(curr_node)
            ret = -1.0
            neighbours = graph[curr_node]
            if target_node in neighbours:
                return path * neighbours[target_node]
            else:
                for nei, val in neighbours.items():
                    if nei in visited: continue
                    ret = dfs(nei, target_node, path*val, visited)
                    if ret != -1.0:
                        break
            visited.remove(curr_node)
            return ret
        result= []
        ret = -1.0
        for (div1, div2), val in zip(equations, values):
            graph[div1][div2] = val
            graph[div2][div1] = 1 / val
        for div1, div2 in queries:
            if div1 not in graph or div2 not in graph:
                ret = -1.0
            elif div1 == div2:
                ret = 1.0
            else:
                visited = set()
                ret = dfs(div1, div2, 1, visited)
            result.append(ret)
        return result