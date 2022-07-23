class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> lst = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] can, int target) {
        backtrack(can, target, 0);
        return res;
    }
    public void backtrack(int[] can, int target, int idx) {
        //base case
        if(target == 0) {
            res.add(new ArrayList<>(lst));
            return;
        }
        for(int i = idx; i < can.length; i++) {
            if(can[i] <= target) {
                lst.add(can[i]);           
                backtrack(can, target - can[i], i);
                lst.remove(lst.size() - 1);
            }
        }
    }
}