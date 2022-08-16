class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums[nums.length - 1];
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(count(nums, mid) >= k) r = mid;
            else l = mid + 1;
        }
        return l;
    }
    public int count(int[] nums, int target) {
        int res = 0;
        int l = 0;
        for(int i = 0; i < nums.length; i++) {
            while(l < i && nums[i] - nums[l] > target) l++;
            res += i - l;
        }
        return res;
    }
}