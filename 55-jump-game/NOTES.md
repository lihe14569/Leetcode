方法一： dfs (TLE) TIME O(2^N)
```
public boolean canJump(int[] nums) {
//dfs
return canJumpFrom(0, nums);
}
public boolean canJumpFrom(int i, int[] nums) {
if(i == nums.length - 1) return true;
int nextMax = Math.min(i + nums[i], nums.length - 1);
for(int j = i + 1; j <= nextMax; j++) {
if(canJumpFrom(j, nums))
return true;
}
return false;
}
```
​
方法二： DP TIME O(N^2)
```
Integer[] memo;
public boolean canJump(int[] nums) {
int n = nums.length;
memo = new Integer[n];
//注意标记终止的条件
memo[n - 1] = 1;
//Recursion + memo