class Solution {
    public int trap(int[] height) {
        //单调栈解法
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int lowIdx = stack.pop();
                if(stack.isEmpty()) break;
                int h = Math.min(height[i], height[stack.peek()]);
                int width = i - stack.peek()  - 1;
                res += width * (h - height[lowIdx]);
            }
            stack.push(i);
        }
        return res;
    }
}