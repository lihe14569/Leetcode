class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] score = new int[n];
        score[0] = nums[0];
        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(0);
        for(int i = 1; i < n; i++) {
            //pop old element
            while(!q.isEmpty() && q.peekFirst() < i - k) {
                q.pollFirst();
            }
            score[i] = score[q.peekFirst()] + nums[i];
            //maintain decreasing
            while(!q.isEmpty() && score[i] >= score[q.peekLast()]) {
                q.pollLast();
            }
            q.offerLast(i);
        }
        return score[n - 1];
    }
}