class NumArray:

    def __init__(self, nums: List[int]):
        self.nums = nums
        self.pf = [0] * (len(nums) + 1)
        for i in range(1, len(nums) + 1):
            self.pf[i] = self.pf[i - 1] + nums[i - 1]

    def sumRange(self, left: int, right: int) -> int:
        return self.pf[right + 1] - self.pf[left]


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(left,right)