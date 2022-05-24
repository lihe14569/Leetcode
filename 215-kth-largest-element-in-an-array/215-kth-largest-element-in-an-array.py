class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        #from kth largest number to kth smallest number
        k = len(nums) - k
        #k is 0-based index to the target number
        def quickselect(nums, target_rank):
            if len(nums) <= 1:
                return nums[0]
            pivot = nums[len(nums)//2]
            left = [x for x in nums if x < pivot]
            mid = [x for x in nums if x == pivot]
            right = [x for x in nums if x > pivot]
            
            nums, i, j = left + mid + right, len(left), len(left) + len(mid)
            if target_rank < i:
                return quickselect(left, target_rank)
            elif target_rank > j:
                return quickselect(right, target_rank - j)
            else:
                return nums[target_rank]
            
        return quickselect(nums, k)