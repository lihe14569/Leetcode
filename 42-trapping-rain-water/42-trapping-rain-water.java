class Solution {
    public int trap(int[] height) {
        int res = 0;
        int n = height.length;
        int l = 0, r = n - 1;
        int lmax = height[0], rmax = height[n - 1];
        while(l <= r) {
            if(lmax <= rmax) {
                if(height[l] <= lmax) {
                    res += lmax - height[l];
                } else {
                    lmax = height[l];
                }
                l++;
            } else {
                if(height[r] <= rmax) {
                    res += rmax - height[r];
                } else {
                    rmax = height[r];
                }
                r--;
            }
        }
        return res;
    }
}