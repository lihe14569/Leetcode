class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while(l < h) {
            int m = l + (h - l) / 2;
            if(nums[m] < nums[h])
                h = m;
            else if(nums[m] > nums[h])
                l = m + 1;
            else {
                if(nums[h - 1] > nums[h]) {
                    l = h;
                    break;
                }
                h--; 
            }
        }
        int rot = l;
        l = 0;
        h = nums.length -1;
        while(l <= h) {
            int m = l + (h - l) / 2;
            int realMid = (m + rot) % nums.length;
            if(nums[realMid] == target) return true;
            else if(nums[realMid] < target)
                l = m + 1;
            else 
                h = m - 1;
        }
        return false;
    }
}