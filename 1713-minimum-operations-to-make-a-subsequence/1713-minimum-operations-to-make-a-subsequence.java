class Solution {
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < target.length; i++) {
            map.put(target[i], i);
        }
        int[] nums = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            nums[i] = map.getOrDefault(arr[i], -1);
        }
        return target.length - getLIS(nums);
    }
    public int getLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for(int num : nums) {
            if(num == -1) continue;
            int i = Arrays.binarySearch(dp, 0, len, num);
            if(i < 0) i = -i - 1;
            dp[i] = num;
            if(i == len) len++;
        }
        return len;
    }
}