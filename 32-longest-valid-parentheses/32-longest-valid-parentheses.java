class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i = 0, start = -1; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if(!stack.isEmpty()) {
                    stack.pop();
                    if(!stack.isEmpty()) res = Math.max(res, i - stack.peek());
                    else res = Math.max(res, i - start);
                } else {
                    start = i;
                }
            }
        }
        return res;
    }
}