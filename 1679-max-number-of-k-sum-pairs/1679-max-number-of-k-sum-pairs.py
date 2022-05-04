class Solution:
    def maxOperations(self, nums: List[int], k: int) -> int:
        dic = defaultdict(int)
        res= 0
        for num in nums:
            if dic[k - num] > 0:
                dic[k- num] -= 1
                res += 1
            else:
                dic[num] += 1
        return res