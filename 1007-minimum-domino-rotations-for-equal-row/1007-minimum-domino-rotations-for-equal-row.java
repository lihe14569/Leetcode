class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int rotations = check(tops[0], tops, bottoms);
        if(rotations != -1) return rotations;
        else return check(bottoms[0], tops, bottoms);
    }
    public int check(int x, int[] tops, int[] bottoms) {
        int n = tops.length;
        int ra = 0, rb = 0;
        for(int i = 0; i < n; i++) {
            if(tops[i] != x && bottoms[i] != x) return -1;
            else if(tops[i] != x) ra++;
            else if(bottoms[i] != x) rb++;
        }
        return Math.min(ra, rb);
    }
}