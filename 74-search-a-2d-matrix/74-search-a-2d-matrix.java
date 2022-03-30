class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) l = mid + 1;
            else r = mid;
        }
        int row = l / n;
        int col = l % n;
        return matrix[row][col] == target;
    }
}