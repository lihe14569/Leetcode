//corner case
if(k == 1) {
if(nums1.length == i) return nums2[j];
//??为什么要求min
//因为k=1，即两个有序数组的第一个数，那就是两个数组各自第一个数里面的最小数
else return Math.min(nums1[i], nums2[j]);
}
//特判的情况，初始的index正好是nums1的长度，nums1是空，只需取nums2的第k位即可
if(nums1.length == i) return nums2[j + k - 1];
//注意：si，sj是第 k/2位的后一位的index。
//用nums1数组来举例，可以理解为[i, si - 1]和[si, nums1.length]
int si = Math.min(nums1.length, i + k / 2), sj = j + k - k / 2;
if(nums1[si - 1] < nums2[sj - 1]) {
return find(nums1, si, nums2, j, k - (si - i));
} else {
return find(nums1, i, nums2, sj, k - (sj - j));
}
}
}
```
​
​
python divide and conquer method
```
class Solution:
def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
m, n = len(nums1), len(nums2)
tot = m + n
if tot % 2 == 0:
left = self.findM(nums1, 0, nums2, 0, tot // 2)
right = self.findM(nums1, 0, nums2, 0, tot // 2 + 1)
return  (left + right) / 2
else:
return self.findM(nums1, 0, nums2, 0, tot // 2 + 1)
def findM(self, nums1, i, nums2, j, k):
if(len(nums1) - i > len(nums2) - j):
return self.findM(nums2, j, nums1, i, k)
if k == 1:
if i == len(nums1): return nums2[j]
else: return min(nums1[i], nums2[j])
if i == len(nums1):
return nums2[j + k - 1]
si = min(len(nums1), i + k // 2)
sj = j + k - k // 2
if(nums1[si - 1] > nums2[sj - 1]):
return self.findM(nums1, i, nums2, sj, k - (sj - j))