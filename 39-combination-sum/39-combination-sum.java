class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> lst = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        return res;
    }
    public void backtrack(int[] candidates, int target, int idx) {
        if(target == 0) {
            res.add(new ArrayList<>(lst));
            return;
        }
        for(int i = idx; i < candidates.length; i++) {
            if(target - candidates[i] >= 0) {
                lst.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i);
                lst.remove(lst.size() - 1);
            }
        }
    }
}