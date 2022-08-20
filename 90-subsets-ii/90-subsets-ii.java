class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(nums, res, path, 0);
        return res;
    }
    public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> path, int start) {
        if(start == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
            
        
        int i = start + 1;
        while(i < nums.length && nums[i] == nums[start]) i++;
        
        for(int j = 0; j <= i - start; j++) {
            backtrack(nums, res, path, i);
            path.add(nums[start]);
        }
        
        for(int j = 0; j <= i - start; j++) {
            path.remove(path.size() -1);
        }
    }
}