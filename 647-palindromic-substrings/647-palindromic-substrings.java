class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            res += panlin(s, i, i);
            res += panlin(s, i, i + 1);
        }
        return res;
    }
    public int panlin(String s, int i, int j) {
        int res = 0;
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            res++;
            i--;
            j++;
        }
        return res;
    }
}