class Solution {
    public int minAddToMakeValid(String s) {
        int balance = 0;
        int right = 0;
        for(char c : s.toCharArray()) {
            if(c == '(')
                right++;
            else {
                if(right == 0) balance++;
                else right--;
            }
        }
        return balance +right;
    }
}