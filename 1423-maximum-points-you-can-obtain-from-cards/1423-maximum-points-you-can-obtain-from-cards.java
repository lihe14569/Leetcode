class Solution {
    public int maxScore(int[] cp, int k) {
        //max sum array 补集
        int n = cp.length;
        k = n - k;
        int curr = 0, l = 0;
        int res = Integer.MAX_VALUE;
        int sum= Arrays.stream(cp).sum();
        if(k == 0) return sum;
        for(int i = 0; i < n; i++) {
            curr += cp[i];
            if(i < k - 1) continue;
            res = Math.min(res, curr);
            curr -= cp[l++];
        }
        return sum - res;
    }
}