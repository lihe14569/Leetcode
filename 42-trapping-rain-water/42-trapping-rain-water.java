class Solution {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res =0;
        for(int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peekLast()]) {
                int lowIndex = stack.pollLast();
                if(stack.isEmpty()) break;
                int wall = Math.min(height[i], height[stack.peekLast()]);
                int width = i - stack.peekLast() - 1;
                res +=(wall - height[lowIndex]) * width;
            }
            stack.offerLast(i);
        }
        return res;
    }
}