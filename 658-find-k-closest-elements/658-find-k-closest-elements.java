class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - k;
        while(l < r) {
            int m = l + (r - l ) / 2;
            if(arr[m + k] - x >= x - arr[m]) r = m;
            else l = m + 1;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            res.add(arr[l + i]);
        }
        return res;
    }
}