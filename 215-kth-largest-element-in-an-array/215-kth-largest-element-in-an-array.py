class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        #QUICKFIND
        k = len(nums) - k
        
        def quickselect(nums, start, end, k):
            if start == end: return nums[start]
            
            def partition(nums, start, end):
                pivot = nums[end]
                wall = start
                for j in range(start, end):
                    if nums[j] < pivot:
                        nums[j], nums[wall] = nums[wall], nums[j]
                        wall += 1
                nums[wall], nums[end] = nums[end], nums[wall]
                return wall
            
            idx = partition(nums, start, end)
            if idx == k:
                return nums[k]
            elif idx < k:
                return quickselect(nums, idx + 1, end, k)
            else:
                return quickselect(nums, start, idx - 1, k)
        return quickselect(nums, 0, len(nums) - 1, k)
                        