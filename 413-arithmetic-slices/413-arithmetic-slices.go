func numberOfArithmeticSlices(nums []int) int {
    n := len(nums)
    dp := make([]int, n)
    
    res := 0
    for i := 2; i < n; i++ {
        if nums[i] - nums[i - 1] == nums[i -1] - nums[i - 2] {
            dp[i] += dp[i -1] + 1
        }
        res += dp[i]
    }
    return res
}