class Solution {
    public String convert(String s, int numRows) {
        String res = "";
        int n = numRows;
        if(n == 1) return s;
        for(int i = 0; i < numRows; i++) {
            if(i == 0 || i == numRows - 1) {
                for(int j = i; j < s.length(); j += 2* n - 2) {
                    res += s.charAt(j);
                }
            } else {
                for(int j = i, k = 2* n - 2 - i; j < s.length() || k < s.length(); j+= 2*n - 2, k += 2*n - 2) {
                    if(j < s.length()) res += s.charAt(j);
                    if(k < s.length()) res += s.charAt(k);
                }
            }
        }
        return res;
    }
}