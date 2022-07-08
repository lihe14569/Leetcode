class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && t[stack.peek()] < t[i]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}