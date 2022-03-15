class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length() + 1];
        return helper(s, memo, 0);
    }
    public int helper(String s, int[] memo, int i) {
        //base case
        if(i == s.length()) return 1; //代表recursion tree里面的一个valid的结果
        if(memo[i] != 0) return memo[i];
        if(s.charAt(i) == '0') return 0;
        if(isvalidTwo(s, i)) memo[i] = helper(s, memo, i + 1) + helper(s, memo, i + 2);
        else memo[i] = helper(s, memo, i + 1);
        return memo[i];
    }
    public boolean isvalidTwo(String s, int i) {
        return i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'));
    }
}