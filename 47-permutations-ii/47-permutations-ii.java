class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(nums, res, list, visited);
        return res;
    }
    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] visited) {
        //判断条件
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            //determine duplicate
            if(visited[i] || (i != 0 && nums[i] == nums[i - 1] && visited[i - 1]))
                continue;
            visited[i] = true;
            list.add(nums[i]);
            dfs(nums, res, list, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}