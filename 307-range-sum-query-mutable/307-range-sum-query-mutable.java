class BIT {
    int[] sums;
    BIT(int size) {
        sums = new int[size + 1];
    }
    int lowbit(int x) {
        return x & (-x);
    }
    void addValue(int i, int val) {
        while(i < sums.length) {
            sums[i] += val;
            i += lowbit(i);
        }
    }
    int getSum(int i) {
        int sum = 0;
        while(i > 0) {
            sum += sums[i];
            i -= lowbit(i);
        }
        return sum;
    }
    int getRangeSum(int l, int r) {
        return getSum(r) - getSum(l - 1);
    }
}
class NumArray {
    int[] nums;
    BIT bit;
    public NumArray(int[] nums) {
        this.nums = nums;
        bit = new BIT(nums.length);
        for(int i = 0; i < nums.length; i++) {
            bit.addValue(i + 1, nums[i]);
        }
    }
    
    public void update(int index, int val) {
        int diff = val - nums[index];
        bit.addValue(index + 1, diff);
        nums[index] = val;
    }
    
    public int sumRange(int left, int right) {
        return bit.getRangeSum(left + 1, right + 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */