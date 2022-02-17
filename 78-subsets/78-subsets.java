class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        
        dfs(nums, res, sol, 0);
        return res;
    }
    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> sol, int start) {
        res.add(new ArrayList<>(sol));

        for(int i = start; i < nums.length; i++) {
            sol.add(nums[i]);
            dfs(nums, res, sol, i + 1);
            sol.remove(sol.size()  - 1);
        }
    }
}