class Solution {
    public int strStr(String s, String p) {
        //kmp
        int m = s.length(), n = p.length();
        s = ' '+ s;
        p = ' ' + p;
        //next代表从 1 到 i 区间里的前缀和后缀相同的最长子字符串的长度
        int[] next = new int[n + 1];
        //not its self, so next[1] = 0, for loop i starts from 2
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