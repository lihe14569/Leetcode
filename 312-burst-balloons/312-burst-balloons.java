class Solution {
    public int maxCoins(int[] nums) {
        //top down dp
        int n = nums.length;
        int[] arr = new int[n + 2];
        System.arraycopy(nums, 0, arr, 1, n);
        arr[0] = 1;
        arr[n + 1] = 1;
        int[][] memo = new int[n+ 2][n + 2]; //注意base case
        return dp(arr, memo, 1, n );
    }
    public int dp(int[] arr, int[][] memo, int left, int right) {
        if(left > right)
            return 0;
        if(memo[left][right] > 0)
            return memo[left][right];
        int max = 0;
        for(int i = left; i <= right; i++) {
            int gain = arr[left - 1] * arr[i] * arr[right + 1];
            int remaining = dp(arr, memo, left, i - 1) + dp(arr, memo, i + 1, right);
            max = Math.max(max, gain + remaining);
        }
        memo[left][right] = max;
        return max;
    }
}