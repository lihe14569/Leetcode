class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy = [0 for i in range(len(prices))]
        sell = [0 for i in range(len(prices))]
        
        if len(prices) == 1:
            return 0
        if len(prices) == 2:
            return max(0, prices[1] - prices[0])
        buy[0] = -prices[0]
        sell[0] = 0
        buy[1] = max(-prices[0], -prices[1])
        sell[1] = max(sell[0], prices[1] - prices[0])
        
        for i in range(2, len(prices)):
            buy[i] = max(buy[i - 1], sell[i - 2] - prices[i])
            sell[i] = max(sell[i - 1], buy[i - 1] + prices[i])
        
        return sell[-1]