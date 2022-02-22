class Solution {
    public int fixedPoint(int[] arr) {
        int l = 0, r = arr.length - 1;
        while(l < r) {
            int m = (l + r) / 2;
            if(arr[m] >= m) {
                r = m;
            } else {
                l = m  + 1;
            }
        }
        return arr[l] == l ? l : -1;
    }
}