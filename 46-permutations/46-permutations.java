class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        int[] visited = new int[nums.length];
        dfs(nums, res, sol, visited);
        return res;
    }
    public void dfs(int[] nums, List<List<Integer>> res,  List<Integer> sol, int[] visited) {
        //base case
        if(sol.size() == nums.length) {
            res.add(new ArrayList<>(sol));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(visited[i]== 1) continue;
            sol.add(nums[i]);
            visited[i] = 1;
            dfs(nums, res, sol, visited);
            sol.remove(sol.size() - 1);
            visited[i] = 0;
        }
    }
}