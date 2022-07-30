class Solution {
    public String simplifyPath(String path) {
        
        Deque<String> stack = new ArrayDeque<>();
        Set<String> skip = new HashSet<>(List.of("", "/", ".", ".."));
        
        for(String word : path.split("/")) {
            if(!stack.isEmpty() && word.equals("..")) stack.removeLast();
            else if(!skip.contains(word)) stack.offerLast(word);
        }
        for(String s : stack) {
            System.out.println(s);
        }
        return "/" + String.join("/", stack);
    }
}