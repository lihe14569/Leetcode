class Solution {
    public int[] findErrorNums(int[] nums) {
        //把所有数有序的放在对应的位置上
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        
        //扫描一遍
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) return new int[]{nums[i], i + 1};
        }
        return new int[]{-1, -1};
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}