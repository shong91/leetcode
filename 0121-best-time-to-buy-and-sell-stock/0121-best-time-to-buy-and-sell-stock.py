class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        left = 0  # Buy
        right = 1  # Sell
        max_profit = 0

        while right < len(prices):
            if prices[left] < prices[right]:
                current_profit = prices[right] - prices[left]
                max_profit = max(max_profit, current_profit)
            else:
                left = right
            right += 1

        return max_profit