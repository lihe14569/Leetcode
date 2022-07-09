class Solution {
    public int trap(int[] height) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        // stack.offerLast(-1);
        for(int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peekLast()]) {
                int h = stack.pollLast();
                if(stack.isEmpty()) break;
                int l = stack.peekLast();
                int w = i - l - 1;
                res += (Math.min(height[i], height[l]) - height[h]) * w;
            }
            stack.offerLast(i);
        }
        return res;
    }
}