class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        int idx = 0;
        int row = mat.length, col = mat[0].length;
        Set<Integer> seen = new HashSet<>();
        for(int i = 0; i < col; i++) {
            for(int j = 0; j < row; j++) {
                if(idx == k) return res;
                if(mat[j][i] == 0 && !seen.contains(j)) {
                    res[idx++] = j;
                    seen.add(j);
                }
            }
        }
        if(idx < k){
            for(int i = 0; i < row && idx < k; i++) {
                if(!seen.contains(i)) res[idx++] = i;
            }
        }
        return res;
    }
}