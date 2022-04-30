class Solution:
    def minimumAverageDifference(self, nums: List[int]) -> int:
        n = len(nums)
        prefix, suffix = [0] * (n + 1), [0] * (n + 1)
        
        for i in range(1, n + 1):
            prefix[i] = prefix[i - 1] + nums[i - 1]
        #[0, 2, 7, 10, 19, 24, 27]
        for i in range(n - 1, -1, -1):
            suffix[i] = suffix[i + 1]  + nums[i]         
        #[27, 25, 20, 17, 8, 3, 0]
        #[3, 2, 2, 0, 1, 4]
        min_diff, res = float('inf'), 0
        for i in range(1, n + 1):
            diff1 = prefix[i] // i
            diff2 = suffix[i] // (n - i) if i !=n else 0
            diff = abs(diff1 - diff2)
            if diff < min_diff:
                min_diff = diff
                res = i - 1
        return res