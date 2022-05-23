class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
       if not nums: return
       p = random.choice(nums)
       l, m, r = [x for x in nums if x > p], [x for x in nums if x == p], [x for x in nums if x < p]
       nums, i, j = l+m+r, len(l), len(l)+len(m)
       return self.findKthLargest(nums[:i], k) if k <= i else self.findKthLargest(nums[j:], k-j) if k > j else nums[i]
