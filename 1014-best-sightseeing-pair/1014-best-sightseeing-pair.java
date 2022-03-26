class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int up = values[0];
        int down = values[1] - 1;
        int res = up + down;
        for(int i = 1; i < values.length; i++) {
            down = values[i] - i;
            res = Math.max(res, down  + up);
            up = Math.max(up, values[i] + i);
        }
        return res;
    }
}