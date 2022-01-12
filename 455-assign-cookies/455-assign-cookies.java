class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0, i = 0;
        while(i < s.length && res < g.length) {
            if(g[res] <= s[i]) {
                res++;
                i++;
            } else 
                i++;
        }
        return res;
    }
}