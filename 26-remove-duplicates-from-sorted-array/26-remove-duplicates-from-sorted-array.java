class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for(int num : nums) {
            if(j < 1 || nums[j - 1] != num) 
                nums[j++] = num;
        }
        return j;
    }
}