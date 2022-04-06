class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long[] map = new long[101];
        for(int a : arr) map[a]++;
        
        long res  = 0;
        for(int i = 0; i <= 100; i++) {
            for(int j = i; j <= 100; j++) {
                int k = target - i - j;
                if(k < 0 || k > 100) continue;
                if(i == j && j == k)
                    res += map[i] * (map[i] - 1) * (map[i] - 2) / 6;
                else if(i == j && i != k) {
                    res += map[i] * (map[i]  - 1) * map[k] / 2; 
                } else if(j < k){
                    res += map[i] * map[j] * map[k];
                }
            }
        }
        return (int)(res %(1e9 + 7));
    }
}