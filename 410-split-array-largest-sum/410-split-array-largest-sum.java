class Solution {
    public int splitArray(int[] nums, int m) {
        int sum = 0, maxNum = Integer.MIN_VALUE;
        for(int num : nums) {
            sum += num;
            maxNum = Math.max(num, maxNum);
        }
        int l = maxNum, r = sum +1;
        int res = 0;
        while( l < r) {
            int mid = l + (r - l) / 2;
            if(getMinSum(nums, mid) <= m) {//注意：如果 minSum 值大， 区分的区间就变少，所以应该缩小minSum
                r = mid;
                res = mid;
            }
            else
                l = mid + 1;
        }
        return res;
    }
    public int getMinSum(int[] nums, int mid) {
        int cnt = 0;
        int sum = 0;
        for(int num : nums) {
            if(sum + num <= mid) {
                sum += num;
            } else {
                cnt++;
                sum = num;
            }
        }
        return cnt + 1;
    }
}