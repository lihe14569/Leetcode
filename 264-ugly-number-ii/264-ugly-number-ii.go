func nthUglyNumber(n int) int {
    dp := make([]int, n)
    p1, p2, p3 := 0 , 0 , 0
    dp[0] = 1;
    
    for i:= 1; i < n; i++ {
        min := dp[p1] * 2
        if min > dp[p2] * 3 {
            min = dp[p2] * 3
        }
        if min > dp[p3] * 5 {
            min = dp[p3] * 5
        }
        dp[i] = min
        if dp[i] == dp[p1] * 2 {
            p1++
        } 
        if dp[i] == dp[p2] * 3 {
            p2++
        } 
        if dp[i] == dp[p3] * 5 {
            p3++
        }
    }
    return dp[n - 1]
}