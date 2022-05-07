}
```
quickselect python version
```
def findKthLargest(self, nums: List[int], k: int) -> int:
#quickselect
#based k value, search left half, or right half
k = len(nums) - k
def quickselect(l, r, k):
if l == r: return nums[l]
def partition(l, r):
pivot = nums[r]
wall = l
for j in range(l, r):
if nums[j] < pivot:
nums[j], nums[wall] = nums[wall], nums[j]
wall += 1
nums[wall], nums[r] = nums[r], nums[wall]
return wall
pos = partition(l, r)
if pos == k: return nums[k]
elif pos < k:
return quickselect(pos + 1, r, k)
else:
return quickselect(l, pos - 1, k)
return quickselect(0, len(nums) - 1, k)
```
​
binary search to find the kth largest
​
​