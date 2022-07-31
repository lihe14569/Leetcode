class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        dfs(0, nums, res, lst);
        return res;
    }
    public void dfs(int idx, int[] nums, List<List<Integer>> res, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for(int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(i + 1, nums, res, list);
            list.remove(list.size() - 1);
        }
    }
}