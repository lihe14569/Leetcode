class Solution {
    public int strStr(String s, String p) {
        if(p == null || p.length() == 0) return 0;
        int m = s.length(), n = p.length();
        s = " " + s;
        p = " " + p;
        
        int[] next = new int[n + 1];
        
        for(int i = 2, j = 0; i <= n; i++) {
            while(j != 0 && p.charAt(i) != p.charAt(j + 1)) j = next[j];
            if(p.charAt(i) == p.charAt(j + 1)) j++;
            next[i] = j;
        }
        
        for(int i = 1, j = 0; i <= m; i++) {
            while(j != 0 && s.charAt(i) != p.charAt(j + 1)) j = next[j];
            if(s.charAt(i) == p.charAt(j + 1)) j++;
            if(j == n) return i - n;
        }
        return -1;
    }
}