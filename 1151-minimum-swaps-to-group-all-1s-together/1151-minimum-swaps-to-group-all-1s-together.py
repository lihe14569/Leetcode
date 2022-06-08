class Solution:
    def minSwaps(self, data: List[int]) -> int:
        cnt = Counter(data)
        ones = cnt[1]
        l, curr = 0, 0
        res = 0
        for i in range(len(data)):
            curr += 1 if data[i] else 0
            if i - l + 1 < ones:
                continue
            res = max(res, curr)
            curr -= 1 if data[l] else 0
            l += 1
            
        return ones - res
        