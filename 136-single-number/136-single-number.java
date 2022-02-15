class Solution {
    public int singleNumber(int[] nums) {
        //bit 
        int res = 0;
        for(int num  : nums) {
            res ^= num;
        }
        return res;
    }
}