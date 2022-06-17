class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int l = matrix[0][0], r = matrix[m - 1][n - 1];
        while(l < r) {
            int mid = l + (r - l) / 2;
            int cnt = count(matrix, mid);
            if(cnt >= k) r = mid;
            else l = mid + 1;
        }
        return l;
    }
    int count(int[][] matrix, int mid) {
        int m = matrix.length, n = matrix[0].length;
        int cnt = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n && matrix[i][j] <= mid; j++) {
                cnt++;
            }
        }
        return cnt;
    }
}