class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        dic = set(wordDict)
        res = []
        def dfs(i, lst):
            if i >= len(s):
                res.append(' '.join(lst))
                return
                
            for j in range(i + 1, len(s) + 1):
                if s[i:j] in dic:
                    lst.append(s[i:j])
                    dfs(j, lst)
                    lst.pop()
            
        dfs(0, [])
        return res
        