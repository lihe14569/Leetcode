class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(0, res, list, nums);
        return res;
    }
    public void dfs(int idx, List<List<Integer>> res, List<Integer> list, int[] nums) {
        res.add(new ArrayList<>(list));
        for(int i = idx;i < nums.length; i++) {
            if(i != idx && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            dfs(i + 1, res, list, nums);
            list.remove(list.size() - 1);
        }
    }
}