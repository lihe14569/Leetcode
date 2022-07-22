class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while(i > 0 && nums[i - 1] >= nums[i]) i--;
        if(i <= 0) {
            Arrays.sort(nums);
        } else {
            int j = i;
            while(j < nums.length && nums[i - 1] < nums[j]) j++;
            swap(nums, i - 1, j - 1);
            Arrays.sort(nums, i, nums.length);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}