class Solution:
    def maximumUniqueSubarray(self, nums: List[int]) -> int:
        #slidng window
        res,curr,l =0, 0, 0
        seen = set()
        for i in range(len(nums)):
            while l <= i and nums[i] in seen:
                curr -= nums[l]
                seen.remove(nums[l])
                l += 1
            seen.add(nums[i])
            curr += nums[i]
            res = max(res, curr)
        return res
            
            
            