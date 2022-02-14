class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //            []
        //.          /. \ \
        //         [1] [2] [3]
        //         /\   /\  /\
        //        [2][3]
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums, res, list, 0);
        return res;
    }
    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, int idx) {
        res.add(new ArrayList<>(list));
        for(int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}