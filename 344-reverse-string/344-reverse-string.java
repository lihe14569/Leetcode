class Solution {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while(l < r) {
            swap(s, l++ , r--);
        }
    }
    public void swap(char[] s, int l, int r) {
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }
}