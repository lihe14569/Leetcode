class Solution {
    public int trap(int[] height) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int low = stack.pop();
                if(stack.isEmpty()) break;
                int l = stack.peek();
                res += (i - l - 1) * (Math.min(height[i], height[l]) - height[low]);
            }
            stack.push(i);
        }
        return res;
    }
}