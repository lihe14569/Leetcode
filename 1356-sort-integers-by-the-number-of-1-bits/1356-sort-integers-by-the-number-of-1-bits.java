class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = arr[i] + Integer.bitCount(arr[i]) * 10001;
        }
        Arrays.sort(res);
        for(int i = 0; i < n; i++) {
            res[i] %= 10001;
        }
        return res;
    }
}