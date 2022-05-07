class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        dic = {0:'',1:'', 2: 'abc', 3: 'def', 4: 'ghi', 5:'jkl', 6: 'mno', 7:'pqrs', 8:'tuv', 9:'wxyz'}
        res = []
        def dfs(idx: int, lst:List[str]):
            nonlocal res, dic
            if len(lst) == len(digits):
                res.append(''.join(lst))
                return 
            num = int(digits[idx])
            for c in dic[num]:
                lst.append(c)
                dfs(idx + 1, lst)
                lst.pop()
        if not digits: return res
        dfs(0, [])
        return res