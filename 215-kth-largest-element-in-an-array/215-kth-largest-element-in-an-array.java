import java.util.Random;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //quickselect
        k = nums.length - k;
        return quickselect(nums, 0, nums.length -1, k);
    }
    public int quickselect(int[] nums, int l, int r, int k) {
        if(l == r) return nums[l];
        Random rand = new Random();
        int pivotIdx = l + rand.nextInt(r - l);
        pivotIdx = partition(nums, l, r, pivotIdx);
        if(pivotIdx == k) return nums[k];
        else if(k < pivotIdx)return quickselect(nums, l, pivotIdx - 1, k);
        else return quickselect(nums, pivotIdx + 1, r, k);
    }
    public int partition(int[] nums, int l, int r, int pivotIdx) {
        int pivot = nums[pivotIdx];
        swap(nums, pivotIdx, r);
        int wall = l;
        for(int i = l; i <= r; i++) {
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