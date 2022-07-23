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
        else:
            return self.findM(nums1, si, nums2, j, k - (si- i))
    