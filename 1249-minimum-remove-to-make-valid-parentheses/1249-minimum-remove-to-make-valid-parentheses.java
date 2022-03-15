class Solution {
    public String minRemoveToMakeValid(String s) {
        //method1: stack
        Set<Integer> toBeRemoved = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') stack.push(i);
            else if(c == ')') {
                if(stack.isEmpty())
                    toBeRemoved.add(i);
                else
                    stack.pop();
            }
        }
        //check the residual stack component
        while(!stack.isEmpty()) {
            toBeRemoved.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(!toBeRemoved.contains(i))
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}