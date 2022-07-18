class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[][] pf = new int[m + 1][n + 1];
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++) {
                pf[i][j] = pf[i - 1][j] + matrix[i - 1][j - 1];
            }
        }
        int res = 0;
        for(int i = 1; i <= m; i++) {
            for(int j= i; j <= m; j++) {
                Map<Integer, Integer> cnt = new HashMap<>();
                int sum = 0;
                cnt.put(0, 1);
                for(int k = 1; k <= n; k++) {
                    sum += pf[j][k] - pf[i - 1][k];
                    res += cnt.getOrDefault(sum - target, 0);
                    cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return res;
    }
}