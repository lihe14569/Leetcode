class Solution {
    public String reverseWords(String s) {
        //revers whole + reverse each
        //trim white spaces
        StringBuilder sb = trimWhiteSpace(s);
    
        sb = reverse(sb);
        reverseEach(sb);
        return sb.toString();
    }
    public StringBuilder trimWhiteSpace(String s) {
        StringBuilder sb= new StringBuilder();
        int l = 0, r = s.length() - 1;
        while(l < r && s.charAt(l) == ' ') l++;
        while(l < r && s.charAt(r) == ' ') r--;
        while(l <= r) {
            int i = l;
            while(i <= r && s.charAt(i) != ' ') i++;
            sb.append(s.substring(l, i));
            if(sb.charAt(sb.length() - 1) != ' ') sb.append(' ');
            while(i <= r && s.charAt(i) == ' ') i++;
            l = i;
        }
        sb.deleteCharAt(sb.length() -1);
        return sb;
    }
    public StringBuilder reverse(StringBuilder sb) {
        return sb.reverse();
    }
    public void reverseEach(StringBuilder sb) {
        int l = 0, r = 0;
        int n = sb.length();
        while(l < n) {
            while(r < n && sb.charAt(r) != ' ') r++;
            reverseStr(sb, l, r - 1);
            l = r + 1;
            r++;
        }
    }
    public void reverseStr(StringBuilder sb, int l, int r) {
        while(l < r) {
            char temp = sb.charAt(l);
            sb.setCharAt(l++,sb.charAt(r));
            sb.setCharAt(r--, temp);
        }
    }
    
}