class Solution {
    public int trap(int[] height) {
        int res = 0;
        int n = height.length;
        if(n == 1) return 0;
        int l  = 0, r = n - 1, lmax = 0, rmax = 0;
        while(l < r) {
            if(height[l] <= height[r]) {
                if(height[l] < lmax) {
                    res += lmax - height[l];
                } else {
                    lmax = height[l];
                }
                l++;
            } else {
                if(height[r] < rmax)
                    res += rmax - height[r];
                else 
                    rmax = height[r];
                r--;
            }
        }
        return res;
    }
}