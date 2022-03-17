class Solution {
    public int minAddToMakeValid(String s) {
        int left = 0;
        int right = 0;
        for(char c : s.toCharArray()) {
            if(c == '(')
                right++;
            else {
                if(right == 0) left++;
                else right--;
            }
        }
        return left +right;
    }
}