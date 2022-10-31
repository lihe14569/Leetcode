class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Map<Integer, Integer> group = new HashMap<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!group.containsKey(i - j))
                    group.put(i-j, matrix[i][j]);
                else {
                    if(group.get(i- j) != matrix[i][j])
                        return false;
                }
            }
        }
        return true;
    }
}