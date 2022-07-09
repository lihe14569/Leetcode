class Solution {
    public String smallestSubsequence(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) map.put(s.charAt(i), i);
        Set<Character> seen = new HashSet<>();
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            if(!seen.contains(c1)) {
                while(!stack.isEmpty() && c1 < stack.peekLast() && map.get(stack.peekLast()) > i) {
                    char c2 = stack.pollLast();
                    seen.remove(c2);
                }
                System.out.println(c1);
                stack.offerLast(c1);
                seen.add(c1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}