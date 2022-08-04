class Solution {
    public int arraySign(int[] nums) {
        int neg = 0, pos = 0;
        for(int num : nums) {
            if(num > 0) pos++;
            else if(num < 0) neg--;
            else return 0;
        }
        if(neg % 2 == 0) return 1;
        else return -1;
    }
}