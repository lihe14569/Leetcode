class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //top-down 
        Set<String> dict = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return dp(s, dict, 0, memo);
    }
    public boolean dp(String s, Set<String> dict, int start, Boolean[] memo) {
        //base case
        if(start >= s.length()) return true;
        //check if we already vsited here
        if(memo[start] != null) return memo[start];
        for(int i = start; i < s.length(); i++) {
            String part = s.substring(start, i + 1);
            if(dict.contains(part) && dp(s, dict, i + 1, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}