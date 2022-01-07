class Solution {
    public boolean validPalindrome(String s) {
        //two pointer
        int i = 0, j = s.length() - 1;
        while(i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        if(i >= j) return true;
        if(isPanlindrome(s, i + 1, j) || isPanlindrome(s, i, j - 1)) return true;
        else return false;
    }
    public boolean isPanlindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }
}