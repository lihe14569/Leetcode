class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; ; i++) {
            int len = strs[0].length();
            if(i >= len) break;
            char c = strs[0].charAt(i);
            for(int j = 0; j < strs.length; j++) {
                if(strs[j].length() <= i || c != strs[j].charAt(i)) return sb.toString();
            }
            sb.append(c);
        }
        return sb.toString();
    }
}