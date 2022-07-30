class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        
        for(int r : row) {
            Arrays.fill(matrix[r], 0);
        }
        for(int c : col) {
            for(int i  = 0; i < m; i++) {
                matrix[i][c] = 0;
            }
        }
    
    }
}