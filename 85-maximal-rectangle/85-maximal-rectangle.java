class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') {
                    if(i > 0) dp[i][j] = dp[i - 1][j] + 1;
                    else dp[i][j] = 1;
                }
            }
        }
        int res = 0;
        for(int i = 0; i < m; i++)  res = Math.max(res, findLargestRectangle(dp[i]));
        return res;
    }
    public int findLargestRectangle(int[] h) {
        int n = h.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for(int i = 0; i < n; i++) {
            while(stack.peek() != -1 && h[stack.peek()] > h[i]) {
                int hi = h[stack.pop()];
                int w = i - stack.peek() - 1;
                max = Math.max(max, w * hi);
            }
            stack.push(i);
        }
        while(stack.peek() != -1) {
            int hi = h[stack.pop()];
            int w = n - stack.peek() - 1;
            max = Math.max(max, w * hi);
        }
        return max;
    }
}