class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if(n < 2) return false;
        Map<Integer, Integer> map = new HashMap<>(); //k:v = remainder : index
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum =(sum + nums[i]) % k;

            if(map.containsKey(sum)) { //注意！prefix2 - prefix1 
                if(i - map.get(sum) > 1) //题目要求at least 2 element,这里差值就是element的个数
                    return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}