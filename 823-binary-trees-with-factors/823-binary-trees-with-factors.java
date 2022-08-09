class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int mod = 1_000_000_007;
        //dynamic programming
        int n = arr.length;
        Arrays.sort(arr);
        long[] dp = new long[n];
        Arrays.fill(dp, 1);
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++) {
                if(arr[i] % arr[j] == 0) {
                    int right = arr[i] / arr[j];
                    if(map.containsKey(right))
                    dp[i] = (dp[i] + dp[j] * dp[map.get(right)]) % mod;
                }
            }
        }
        long res = 0;
        for(long num : dp) {
            res += num;
        }
        return (int) (res % mod);
    }
}