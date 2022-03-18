class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> seen = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!seen.contains(c)) {
                while(!stack.isEmpty() && c < stack.peek() && map.get(stack.peek()) > i)
                    seen.remove(stack.pop());
                stack.push(c);
                seen.add(c);
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for(char c :stack) sb.append(c);
        return sb.toString();
        
    }
}