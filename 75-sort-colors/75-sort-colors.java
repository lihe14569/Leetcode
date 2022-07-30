class Solution {
    public void sortColors(int[] nums) {
        //三指针
        for(int zero = 0, one = 0, two = nums.length - 1; one <= two; ) {
            if(nums[one] == 0) {
                swap(nums, zero, one);
                zero++;
                one++;
            } else if(nums[one] == 2) {
                swap(nums, one, two);
                two--;
            }else {
                one++;
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}