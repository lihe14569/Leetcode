class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 1, n = nums.length, cnt = 1;
        for(int i = 1; i < n; i++) {
            if(nums[i] != nums[i - 1]) nums[j++] = nums[i];
        }
        return j;
    }
}