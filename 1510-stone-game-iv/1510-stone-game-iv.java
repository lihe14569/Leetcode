class Solution {
    public boolean winnerSquareGame(int n) {
        Map<Integer, Boolean> memo = new HashMap<>();
        memo.put(0, false);
        return dfs(n, memo);
    }
    public boolean dfs(int n, Map<Integer, Boolean> memo) {
        if(memo.containsKey(n)) return memo.get(n);
        int sqrt = (int) Math.sqrt(n);
        for(int i = 1; i <= sqrt; i++) {
            if(!dfs(n - i * i, memo)) {
                memo.put(n, true);
                return true;
            }
        }
        memo.put(n, false);
        return false;
    }
}