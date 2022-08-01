class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubArrayComp(nums, (a,b)->(a < b)) - sumSubArrayComp(nums, (a,b)->(a > b));
    }

    private long sumSubArrayComp(int[] nums, BiPredicate<Integer,Integer> comp) {
        Deque<Integer> stack = new ArrayDeque<>();
        long res = 0L;
        for (int i = 0; i <= nums.length; i++) {
            while (!stack.isEmpty() && (i == nums.length || comp.test(nums[stack.peek()], nums[i]))) {
                int j = stack.pop(), k = stack.isEmpty() ? -1 : stack.peek();
                res += (long)nums[j] * (i - j) * (j - k);
            }
            stack.push(i);
        }
        return res;
    }
}