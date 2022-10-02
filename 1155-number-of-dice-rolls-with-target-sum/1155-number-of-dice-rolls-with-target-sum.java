class Solution {
    int MOD = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] memo = new Integer[n + 1][target + 1];
        return dfs(memo, 0, n, k, 0, target);
    }
    public int dfs(Integer[][] memo, int cnt, int n, int k, int currSum, int target) {
        if(cnt == n) {
            return currSum == target? 1 : 0;
        }
        if(memo[cnt][currSum] != null) return memo[cnt][currSum];
        int res = 0;
        for(int i = 1; i <= Math.min(target - currSum, k); i++) {
            res = (res + dfs(memo, cnt + 1, n, k, currSum + i, target)) % MOD;
        }
        return memo[cnt][currSum] = res;
    }
}