class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        //quickselect
        return quickselect(nums, 0, nums.length - 1, k);
    }
    public int quickselect(int[] nums, int l, int r, int k) {
        //base case
        if(l == r) return nums[l];
        int index = partition(nums, l, r);
        if(index == k) return nums[k];
        else if(index < k) {
            return quickselect(nums, index + 1, r, k);
        } else {
            return quickselect(nums, l, index - 1, k);
        }
    }
    public int partition(int[] nums, int l, int r) {
        //pivot index is r
        int pivot = nums[r];
        int wall = l;
        for(int i = l; i < r; i++) {
            if(nums[i] < pivot) {
                swap(nums, i, wall);
                wall++;
            }
        }
        swap(nums, wall, r);
        return wall;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}