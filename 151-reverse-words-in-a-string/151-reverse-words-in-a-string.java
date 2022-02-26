class Solution {
    public String reverseWords(String s) {
        //reverse whoe + reverse each
        StringBuilder sb = trimSpaces(s);
        reverse(sb, 0, sb.length() - 1);
        reverseEach(sb);
        return sb.toString();
    }
    
    public StringBuilder trimSpaces(String s) {
        StringBuilder sb = new StringBuilder();
        int l = 0, r = s.length() - 1;
        while(l <= r && s.charAt(l) == ' ') l++;
        while(l <= r && s.charAt(r) == ' ') r--;
        
        while(l <= r) {
            char c = s.charAt(l);
            if(c != ' ') sb.append(c);
            else if(sb.charAt(sb.length() - 1) != ' ') sb.append(' ');
            l++;
        }
        return sb;
    }
    //reverse the whole string
    public void reverse(StringBuilder sb, int start, int end) {
        while(start < end) {
            char c = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, c);
        }
    }
    
    public void reverseEach(StringBuilder sb) {
        int start = 0, end = 0;
        int n = sb.length();
        while(start < n) {
            while(end < n && sb.charAt(end) != ' ') end++;
            reverse(sb, start, end - 1);
            start = end + 1;
            end = start;
        }
    }
}