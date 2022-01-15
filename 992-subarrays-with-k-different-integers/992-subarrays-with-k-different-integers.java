class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    public int atMostK(int[] nums, int k) {
        int N = nums.length;
        int res = 0, left = 0, cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            //put in
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            //move out
            while(map.size() > k) {
                map.put(nums[left], map.getOrDefault(nums[left], 0) -1);
                if(map.get(nums[left]) == 0)
                    map.remove(nums[left]);
                left++;
            }
            //calculate
            //***a little bit ambiguous/hard to understand***
            res += i - left + 1;
        }
        return res;
    }
}