python remove leading and trailing whitespace
```
s.strip()
```
​
方法一： remove leading/trailing whitespaces + find the last word
```
class Solution:
def lengthOfLastWord(self, s: str) -> int:
s= s.strip()
print(s)
for i in range(len(s) - 1, -1, -1):
if s[i] == ' ':
return len(s[i + 1:])
return len(s)
```
​
方法二：
​