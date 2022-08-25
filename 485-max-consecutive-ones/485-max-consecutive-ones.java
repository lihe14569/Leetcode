class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int curr= 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                while(i < nums.length && nums[i] == 1)  {
                    i++;
                    curr++;
                }
                res = Math.max(res, curr);
            }
            curr = 0;
        }
        return res;
    }
}