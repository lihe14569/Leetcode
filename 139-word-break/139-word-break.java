class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        Set<String> words = new HashSet<>(wordDict);
        return helper(s, words, memo, 0);
    }
    public boolean helper(String s, Set<String> words, Boolean[] memo, int start) {
        //base 
        if(start == s.length()) return true;
        if(memo[start] != null) return memo[start];
        for(int end = start + 1; end <= s.length(); end++) {
            if(words.contains(s.substring(start, end)) && helper(s, words,memo, end))
                return memo[start] = true;
        }
        return memo[start] = false;
    }
}