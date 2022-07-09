class Solution {
    public int largestRectangleArea(int[] h) {
        int res = 0;
        int n = h.length;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for(int i = 0; i < n; i++) {
            while(stack.peek() != -1 && h[i] < h[stack.peek()]) {
                int l = stack.pop();
                res = Math.max(res, (i - stack.peek() - 1) * h[l]);
            }
            stack.push(i);
        }
        //corner case: 一直是递增的序列
        while(stack.peek() != -1) {
            int ht = h[stack.pop()];
            int w = n - stack.peek() - 1;
            res = Math.max(res, ht * w);
        }
        return res;
    }
}