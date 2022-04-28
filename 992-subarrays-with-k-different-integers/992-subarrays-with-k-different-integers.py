class Solution:
    def subarraysWithKDistinct(self, nums: List[int], k: int) -> int:
        
        def atMost(nums: List[int], k : int):
            l, n, res= 0, len(nums), 0
            dic = defaultdict(int)
            for i in range(n):
                if dic[nums[i]] == 0: k -= 1
                dic[nums[i]] += 1
                while k < 0:
                    dic[nums[l]] -= 1
                    if dic[nums[l]] == 0: k += 1                    
                    l += 1
                res += i - l + 1
            return res
        
        return atMost(nums, k) - atMost(nums, k - 1)
        
                