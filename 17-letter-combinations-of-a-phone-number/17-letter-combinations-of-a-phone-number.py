class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        #dfs
        
        res = []
        if not digits or len(digits) == 0:
            return res
        dic = {'2': 'abc', '3': 'def', '4': 'ghi', '5':'jkl', '6': 'mno', '7':'pqrs', '8':'tuv', '9':'wxyz'}
        def backtrack(idx, lst):
            nonlocal res, dic
            if idx == len(digits):
                s = ''.join(lst)
                res.append(s)
                return
            for c in dic[digits[idx]]:
                lst.append(c)
                backtrack(idx + 1, lst)
                lst.pop()
        backtrack(0, [])
        return res
            