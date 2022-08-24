class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        for(int i = 0; i < m; i++) sort(mat, i, 0);
        for(int i = 0; i < n; i++) sort(mat, 0, i);
        return mat;
    } 
    public void sort(int[][] mat, int row, int col) {
        int m = mat.length;
        int n = mat[0].length;
        
        List<Integer> diagonal = new ArrayList<>();
        int len = Math.min(m - row, n - col);
        
        for(int i = 0; i < len; i++) {
            diagonal.add(mat[row + i][col + i]);
        }
        Collections.sort(diagonal);
        
        for(int i = 0; i < len; i++) {
            mat[row + i][col + i] = diagonal.get(i);
        }
    }
}