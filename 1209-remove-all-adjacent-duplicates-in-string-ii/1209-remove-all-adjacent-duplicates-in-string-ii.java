class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair('#', 0));
        for(char c : s.toCharArray()) {
            Pair p = stack.peek();
            if(p.c == c) {
                p.cnt++;
                if(p.cnt == k)
                    stack.pop();
            } else {
                stack.push(new Pair(c, 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Pair p : stack) {
            if(p.c != '#') {
                for(int i = 0; i < p.cnt; i++) 
                    sb.append(p.c);
            }
        }
        return sb.toString();
    }
    class Pair {
        char c;
        int cnt;
        Pair(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }
    }
}