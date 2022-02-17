class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list =new ArrayList<>();
        dfs(candidates, target, res, list, 0);
        return res;
    }
    public void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int idx) {
        //base case
        if(target == 0) {
            res.add(new ArrayList<>(list));
        }
        for(int i = idx; i < candidates.length; i++) {
            if(candidates[i] <= target) {
                list.add(candidates[i]);
                dfs(candidates, target - candidates[i], res, list, i);
                list.remove(list.size() - 1);
            }
        }
    }
}