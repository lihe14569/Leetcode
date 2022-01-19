class Solution {
    public int minIncrementForUnique(int[] nums) {
        //count sort
        int n = nums.length;
        int max = 0;
        for(int num : nums) max = Math.max(max, num);
        int[] cnt = new int[n + max];
        for(int num : nums) {
            cnt[num]++;
        }
        int taken = 0, move = 0;
        for(int i = 0; i < n + max; i++) {
            if(cnt[i] >= 2) {
                taken += cnt[i] - 1;
                move -= i *(cnt[i] - 1);
            } else if(taken > 0 && cnt[i] == 0){
                taken--;
                move += i;
            }
        }
        return move;
    }
}