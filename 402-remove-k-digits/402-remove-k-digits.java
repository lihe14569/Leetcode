class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        int cnt = 0;
        for(int i = 0; i < num.length(); i++) {
            char c1 = num.charAt(i);
            while(!stack.isEmpty() && c1 < stack.peekLast() && cnt < k) {
                stack.pollLast();
                cnt++;
            }
            stack.offerLast(c1);
        }
        //remove exactly k character
        while(cnt < k && !stack.isEmpty()) {
            stack.pollLast();
            cnt++;
        }
        StringBuilder sb = new StringBuilder();
        
        for(char c : stack) {
            if(sb.isEmpty() && c == '0') continue;
            sb.append(c);
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }
}