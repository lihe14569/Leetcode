方法汇总：
https://leetcode.com/problems/jump-game-ii/discuss/18089/Evolve-from-brute-force-to-optimal
​
​
方法一： DP + BOTTOM UP  TIME O(N^2)
```
public int jump(int[] nums) {
//BOTTOM UP DP
int n = nums.length;
int[] dp = new int[n];
Arrays.fill(dp, Integer.MAX_VALUE);
dp[0] = 0;
for(int i = 0; i < n; i++) {
for(int j = 0; j < i; j++) {
if(j + nums[j] >= i)
dp[i] = Math.min(dp[i], dp[j] + 1);
}
}
return dp[n - 1];
}
```
​
方法二： DP+ TOP DOWN + memo  Time O(N^2)
```
Integer[] memo;
public int jump(int[] nums) {
int n = nums.length;
memo = new Integer[n];
return jump(0, nums);
}
public int jump(int p, int[] nums) {
if(p >= nums.length - 1) return 0;
if(memo[p] != null)
return memo[p];
int step = nums.length;
for(int i = 1; i <= nums[p]; i++) {
step = Math.min(step, 1 + jump(p + i, nums));
}
return memo[p] = step;
}
```
​
方法三：greedy Time O(n)
```
//eg: nums = [2,3,1,1,4]
// i = 0, far = 0, end = 0; step = 1
// i = 1, far = 2, end = 2, step = 1;
// i = 2, far = 4, end = 2, step = 1
//i = 3, far = 3, end = 3, step = 2