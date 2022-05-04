method1: two pointer +sort
```
def maxOperations(self, nums: List[int], k: int) -> int:
nums.sort()
l, r, cnt = 0, len(nums)- 1, 0
while l < r:
if nums[l] +nums[r] == k:
cnt += 1
l += 1
r -= 1
elif nums[l] +nums[r] < k:
l += 1
else:
r -= 1
return cnt
```
​
method2: two sum
​
```
​
```