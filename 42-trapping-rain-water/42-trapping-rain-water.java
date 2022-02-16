class Solution {
    public int trap(int[] height) {
        //two pointer
        int l = 0,  r= height.length - 1, res = 0;
        int lMax = 0, rMax = 0;
        while(l < r) {
            if(height[l] < height[r]) {
                if(lMax < height[l]) lMax = height[l];
                else {
                    res += lMax - height[l];
                }
                l++;
            } else {
                if(rMax < height[r]) rMax = height[r];
                else res += rMax - height[r];
                r--;
            }
        }
        return res;
    }
}