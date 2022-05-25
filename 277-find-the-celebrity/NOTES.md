method1: o(n^2)
```
for i in range(n):
def isCelebrity(j):
for k in range(n):
if j == k: continue
if knows(j, k) or not knows(k, j):
return False
return True
if isCelebrity(i):
return i
return -1
```
​
method2:
```
class Solution:
def findCelebrity(self, n: int) -> int:
celeb = 0
for i in range(1, n):
if knows(celeb, i):
celeb = i
if self.checkCeleb(celeb, n):
return celeb
return -1
def checkCeleb(self, p, n):