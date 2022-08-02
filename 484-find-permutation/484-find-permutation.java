class Solution {
    public int[] findPermutation(String s) {
        int[] res = new int[s.length() + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        int j = 0;
        for(int i = 1; i <= s.length(); i++) {
            stack.push(i);
            if(s.charAt(i - 1) == 'I') {
                while(!stack.isEmpty()) {
                    res[j++] = stack.pop();
                }
            }
        }
        stack.push(s.length() + 1);
        while(!stack.isEmpty()) res[j++] = stack.pop();
        return res;
    }
}