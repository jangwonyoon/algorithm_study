# Greedy

## leetcode 122. Best Time to Buy and Sell Stock II

### https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

```py
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        result = 0
        # 값이 오르는 경우 매번 그리디 계산
        for i in range(len(prices) - 1):
            if prices[i + 1] > prices[i]:
                result += prices[i + 1] - prices[i]
        return result
```

```py
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # 0보다 크면 무조건 합산
        return sum(max(prices[i + 1] - prices[i], 0) for i in range(len(prices) - 1))
```