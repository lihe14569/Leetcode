class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strs = path.split("/");
        for(int i = 0;i < strs.length; i++) {
            if(!stack.isEmpty() && strs[i].equals(".."))
                stack.pop();
            else if(!strs[i].equals(".") && !strs[i].equals("") && !strs[i].equals(".."))
                stack.push(strs[i]);
        }
        return "/" + String.join("/", stack);
    }
}