class Solution {
    public String getSmallestString(int n, int k) {
        //right to left
        char[] arr = new char[n];
        Arrays.fill(arr, 'a');
        k -= n;
        for(int i = n - 1; i >= 0 && k >= 0; i--) {
            int add = Math.min(k, 25);
            arr[i] = (char) ('a' + add);
            k -= add;
        }
        return new String(arr);
    }
}