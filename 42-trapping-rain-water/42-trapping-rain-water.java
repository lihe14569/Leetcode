class Solution {
    public int trap(int[] height) {
        //two pointer
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int l = stack.pop();
                if(stack.isEmpty()) break;
                int h = Math.min(height[i], height[stack.peek()]);
                int width = i-1 - stack.peek();
                res += width * (h  - height[l]);
            }
            stack.push(i);
        }
        return res;
    }
}