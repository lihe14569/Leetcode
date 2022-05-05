class Solution:
    def findAllRecipes(self, recipes: List[str], ingredients: List[List[str]], supplies: List[str]) -> List[str]:
        n = len(recipes)
        graph, indegree =defaultdict(list), Counter()
        
        for i in range(n):
            for j in ingredients[i]:
                graph[j].append(recipes[i])
                indegree[recipes[i]] += 1
            
        ans = []
        q= deque(supplies)
        
        while q:
            node = q.popleft()
            if node in graph:
                for rcp in graph[node]:
                    indegree[rcp] -= 1
                    if indegree[rcp] == 0:
                        ans.append(rcp)
                        q.append(rcp)
        return ans
        
        