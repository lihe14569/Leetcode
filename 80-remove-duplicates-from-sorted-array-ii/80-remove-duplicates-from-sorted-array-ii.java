class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt = 0;
        for(int num : nums) {
            if(cnt < 2 || nums[cnt - 1] != num || nums[cnt - 2] != num)
                nums[cnt++] = num;
        }
        return cnt;
    }
}