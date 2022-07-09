class Solution {
    public int largestRectangleArea(int[] hs) {
        int n = hs.length;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int res = 0;
        for(int i = 0; i < n; i++) {
            while(stack.peek() != -1 && hs[i] < hs[stack.peek()]) {
                int l = stack.pop();
                res = Math.max(res, (i - stack.peek() - 1) * hs[l]);
            }
            stack.push(i);
        }
        while(stack.peek() != -1) {
            int low = stack.pop();
            res = Math.max(res, (n - stack.peek() - 1) * hs[low]);
        }
        return res;
    }
}