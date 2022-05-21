class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        dic = set(wordDict)
        res = []
        def dfs(i, lst):
            if i >= len(s):
                res.append(' '.join(lst))
                return
                
            for j in range(i, len(s)):
                if s[i:j + 1] in dic:
                    lst.append(s[i:j + 1])
                    dfs(j + 1, lst)
                    lst.pop()
            
        dfs(0, [])
        return res
        