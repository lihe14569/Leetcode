backtrack argument : idx + strings
```
def letterCombinations(self, digits: str) -> List[str]:
dic = {0:'',1:'', 2: 'abc', 3: 'def', 4: 'ghi', 5:'jkl', 6: 'mno', 7:'pqrs', 8:'tuv', 9:'wxyz'}
res = []
def dfs(idx: int, lst:str):
nonlocal res, dic
if len(lst) == len(digits):
res.append(lst[:])
return
num = int(digits[idx])
for c in dic[num]:
lst += c
dfs(idx + 1, lst)
lst= lst[:-1]
if not digits: return res
dfs(0, '')
return res
```
​
method2: idx + lst of string
```
def letterCombinations(self, digits: str) -> List[str]:
dic = {0:'',1:'', 2: 'abc', 3: 'def', 4: 'ghi', 5:'jkl', 6: 'mno', 7:'pqrs', 8:'tuv', 9:'wxyz'}
res = []