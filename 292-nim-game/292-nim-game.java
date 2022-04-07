class Solution {
    public boolean canWinNim(int n) {
        return n % 4!= 0;
    }
    public boolean canWin(int n, Boolean[] memo) {
        //base case
        if(n < 0) return false;
        if(memo[n] != null) return memo[n];
        boolean res = false;
        for(int i = 1; i < 4; i++) {
            if(n >= i)
                res |= !canWin(n - i, memo);
        }
        return memo[n] = res;
    }
}