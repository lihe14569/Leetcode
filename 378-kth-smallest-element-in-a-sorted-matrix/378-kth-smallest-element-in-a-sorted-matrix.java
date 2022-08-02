class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //binary search
        int n = matrix.length;
        int l = matrix[0][0], r = matrix[n - 1][n - 1];
        
        while(l < r) {
            int mid = l + (r - l) / 2;
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n && matrix[i][j] <= mid; j++) {
                    cnt++;
                }
            }
            if(cnt >= k) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}