class Solution {
    public String removeKdigits(String num, int k) {
        //单调栈
        Stack<Character> stack = new Stack<>();
        for(char c : num.toCharArray()) {
            while(!stack.isEmpty() && c < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while(k > 0 && !stack.isEmpty()) {
            k--;
            stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        boolean zero = true;
        for(char c : stack) {
            if(c == '0' && zero) continue;
            else zero = false;
            sb.append(c);
        }
        return sb.length() == 0 ? "0" : sb.toString();
        
    }
}