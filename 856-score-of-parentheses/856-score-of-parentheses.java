class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(curr);
                curr = 0;
            } else {
                curr = stack.pop() + Math.max(2 * curr, 1);
            }
        }
        return curr;
    }
}