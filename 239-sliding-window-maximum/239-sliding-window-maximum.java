class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            int idx = i - k + 1;
            //取出左边界元素
            while(!q.isEmpty() && i - q.peekFirst()  + 1 > k) {
                q.pollFirst();
            }
            //保持queue的单点递减性
            while(!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offerLast(i);
            if(idx >= 0) res[idx] = nums[q.peekFirst()];
        }
        return res;
    }
}