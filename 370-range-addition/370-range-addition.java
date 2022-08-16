class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length];
        
        for(int[] update :updates) {
            int l = update[0];
            int r = update[1];
            int val = update[2];
            diff[l] += val;
            if(r + 1 < length) diff[r + 1] -= val;
        }
        for(int i = 1; i <length; i++) {
            diff[i] += diff[i - 1];
        }
        return diff;
    }
}