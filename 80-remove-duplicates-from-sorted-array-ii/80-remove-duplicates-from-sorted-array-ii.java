class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 1, n = nums.length;
        int cnt = 1;
        for(int i=1;i < n; i++) {
            if(nums[i] == nums[i - 1]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if(cnt <= 2) nums[j++] = nums[i];
        }
        return j;
    }
}