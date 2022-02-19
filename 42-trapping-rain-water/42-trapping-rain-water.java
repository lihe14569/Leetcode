class Solution {
    public int trap(int[] height) {
        //stack 
        int res =  0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int low = height[stack.pop()];
                if(stack.isEmpty()) continue;
                int high = Math.min(height[stack.peek()], height[i]);
                int width = i - stack.peek() - 1;
                res += width * ( high - low);
            }
            stack.push(i);
        }
        return res;
    }
}