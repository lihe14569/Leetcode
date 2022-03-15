class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //recursion
        Boolean[] memo = new Boolean[s.length() + 1];
        Set<String> set = new HashSet<>(wordDict);
        return helper(s, set, memo, 0);
    }
    public boolean helper(String s, Set<String> set, Boolean[] memo, int start) {
        //base case
        if(start == s.length()) return true;
        if(memo[start] != null) return memo[start];
        for(int end = start + 1; end <= s.length(); end++) {
            if(set.contains(s.substring(start, end)) && helper(s, set, memo, end))
                return memo[start] = true;
        }
        return memo[start] =false;
    }
}