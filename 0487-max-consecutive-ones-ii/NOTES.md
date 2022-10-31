方法一： sliding window(python)
```
class Solution:
def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
#sliding window
n, left, res, cnt = len(nums), 0, 0, 0
for i in range(n):
if nums[i] == 0:
cnt += 1
while cnt > 1:
if nums[left] == 0:
cnt -= 1
left += 1
res = max(res, i - left + 1)
return res
```
​
方法二：dp
```
class Solution:
def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
one, zero, res = 0, 1, 0
for i in range(len(nums)):
if nums[i] == 0:
one = zero
zero = 1
else:
one += 1
zero += 1
res = max(res, one)
return res
#i , zero , one, res
#     1      0    0
#0    2      1    1
#1    1      2    2
#2    2      3    3
#3    3      4    4
#4    1      3    4
```