class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        buy = [0 for i in range(len(prices))]
        sell = [0 for i in range(len(prices))]
        
        buy[0] = -prices[0]
        sell[0] = 0
        for i in range(1, len(prices)):
            buy[i] = max(buy[i - 1], sell[i - 1] - prices[i])
            sell[i] = max(sell[i - 1], buy[i - 1] + prices[i] - fee)
        return sell[-1]