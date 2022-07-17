class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        String s = String.valueOf(x);
        return isPanlin(s);
    }
    public boolean isPanlin(String s) {
        int n = s.length();
        int i = (n - 1) / 2, j = n / 2;
        while(i >= 0 && j < n ) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i--;
            j++;
        }
        return true; 
    }
}