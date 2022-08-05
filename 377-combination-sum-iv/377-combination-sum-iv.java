class Solution {
    public int combinationSum4(int[] nums, int target) {
        int res = 0;
        Map<Integer, Integer> memo = new HashMap<>();
        return dfs(nums, target, memo);
    }
    public int dfs(int[] nums, int target, Map<Integer, Integer> memo) {
        if(target == 0) return 1;
        if(target < 0) return 0;
        if(memo.containsKey(target)) return memo.get(target);
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res += dfs(nums, target - nums[i], memo);
        }
        memo.put(target, res);
        return res;
    }
}