class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainder = new int[60];
        int cnt = 0;
        for(int t :time) {
            if( t % 60 == 0) {
                cnt += remainder[0];
            } else {
                cnt += remainder[60 - t % 60];
            }
            remainder[t % 60] += 1;
        }
        return cnt;
    }
}