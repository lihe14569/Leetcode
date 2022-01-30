class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[]dp = new int[n]; //indicates ith row longest consecutive block
        int maxArea = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, findLargestRec(dp));
        }
        return maxArea;
    }
    public int findLargestRec(int[] dp) {
        int n = dp.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for(int i = 0; i < n; i++) {
            while(stack.peek() != -1 && dp[i] <= dp[stack.peek()]) {
                res = Math.max(res, dp[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while(stack.peek() != -1) {
            res = Math.max(res, dp[stack.pop()] * (n - stack.peek() - 1));
        }
        return res;
    }
}