class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = i - (stack.isEmpty() ? 0 : stack.peek() + 1);
                res = Math.max(res, h * w);
            }
            stack.push(i);
        }
        //corner case: check the resut increasing stack
        while(!stack.isEmpty()) {
            int h = heights[stack.pop()];
            int w = n - (stack.isEmpty() ? 0 : stack.peek() + 1);
            res = Math.max(res, h * w);
        }
        return res;
    }
}