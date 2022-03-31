class Solution {
    public int splitArray(int[] nums, int m) {
        int sum = 0, max = Integer.MIN_VALUE;
        for(int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        int l = max, r = sum;
        while( l < r) {
            int mid = l + (r - l) / 2;
            if(getSplits(nums, mid) <= m)
                r = mid;
            else 
                l = mid + 1;
        }
        return l;
    }
    public int getSplits(int[] nums, int mid) {
        int count = 1;
        int sum = 0;
        for(int num : nums) {
            if(sum + num <= mid)
                sum += num;
            else {
                sum = num;
                count++;
            }
        }
        return count;
    }
}