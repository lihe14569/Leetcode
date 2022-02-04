class Solution {
    public int findMaxLength(int[] nums) {
        //label all 0 to -1
        //get subarray sum == 0
        int n = nums.length;
        if(n <= 1) return 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0)
                nums[i] = -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(0, -1); //k: v = sum, index
        int res = 0;
        int sum = 0;
        for(int i= 0; i < n; i++) {
            sum += nums[i];
            if(map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            }
             else {
                 map.put(sum, i);
             }
        }
        return res;
    }
}