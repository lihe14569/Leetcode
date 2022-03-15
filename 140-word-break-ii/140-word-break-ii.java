class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
       
        Set<String> set = new HashSet<>(wordDict);
        
        List<Integer>[] dp = new ArrayList[s.length() + 1];
        for(int i = 0; i <= s.length(); i++) dp[i] = new ArrayList<>();
        dp[0].add(0);// null string
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(!dp[j].isEmpty() && set.contains(s.substring(j, i))) {
                    dp[i].add(j);
                }
            }
        }
        List<String> res = new ArrayList<>();
        getResults(dp, "", s.length(), s, res);
        return res;
    }
    public void getResults(List<Integer>[] dp, String curr, int index, String s, List<String> res) {
        //base case
        if(index == 0) {
            res.add(curr.trim());
            return;
        }
        for(int preIdx : dp[index]) {
            getResults(dp, s.substring(preIdx, index) + " " + curr, preIdx, s, res);
        }
    }
}