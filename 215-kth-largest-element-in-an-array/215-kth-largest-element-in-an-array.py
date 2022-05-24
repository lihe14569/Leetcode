class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        k = len(nums) - k + 1
        def quickselect(nums, k):
            if len(nums) <= 1:
                return nums[0]
            pivot = nums[len(nums)//2]
            left = [x for x in nums if x < pivot]
            mid = [x for x in nums if x == pivot]
            right = [x for x in nums if x > pivot]
            
            nums, i, j = left + mid + right, len(left), len(left) + len(mid)
            if k < i:
                return quickselect(left, k)
            elif k > j:
                return quickselect(right, k - j)
            else:
                return nums[k]
        return quickselect(nums, k - 1)