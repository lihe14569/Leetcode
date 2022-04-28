class Solution:
    def numberOfSubarrays(self, nums: List[int], k: int) -> int:
        def atMost(nums: List[int], k :int) -> int:
            l, n , res = 0, len(nums), 0
            for i in range(n):
                k -= nums[i] % 2
                while k < 0:
                    k += nums[l] % 2
                    l += 1
                res += i - l + 1
            return res
        return atMost(nums, k) - atMost(nums, k - 1)