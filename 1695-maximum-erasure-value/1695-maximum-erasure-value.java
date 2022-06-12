class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int l = 0, res = 0, curr = 0;
        for(int i = 0; i < nums.length; i++) {
            while(!seen.add(nums[i])) {
                curr -= nums[l];
                seen.remove(nums[l]);
                l++;
            }
            curr += nums[i];
            seen.add(nums[i]);
            res = Math.max(res, curr);
        }
        return res;
    }
}