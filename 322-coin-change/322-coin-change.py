class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        coins.sort(reverse=True)
        def dfs(amount, memo):
            if amount == 0:
                return 0
            if amount in memo:
                return memo[amount]
            val = sys.maxsize
            for coin in coins:
                if amount - coin >= 0:
                    val = min(val, 1 + dfs(amount - coin, memo))
                
                memo[amount] = val
            return memo[amount]
        
        res = dfs(amount, {})
        return -1 if res == sys.maxsize else res
        
        
                
                