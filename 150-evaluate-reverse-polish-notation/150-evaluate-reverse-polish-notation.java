class Solution {
    public int evalRPN(String[] tokens) {
        //stack method
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            if(!"+-*/".contains(token)) {
                stack.push(Integer.parseInt(token));
                continue;
            }
            int res = 0;
            int num2 = stack.pop();
            int num1 = stack.pop();
            
            switch(token) {
                case "+":
                    res = num1 + num2;
                    break;
                case "-":
                    res = num1 - num2;
                    break;
                case "*":
                    res = num1 * num2;
                    break;
                case "/":
                    res = num1 / num2;
                    break;
            }
            stack.push(res);
        }
        return stack.pop();
    }
}