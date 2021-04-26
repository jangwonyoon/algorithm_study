# Array

## 121. Best Time to Buy and Sell Stock

### https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

* 파이썬 내 풀이 

- pythonic 하지 못한 풀이 if elif 대신 `max`, `min`을 사용해서 풀어보자 
- 
```py
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        min, max_profit = inf, 0
        
        for price in prices:
            if price < min:
                min = price
            elif price - min > max_profit:
                max_profit = price - min
        
        return max_profit
```

* 레퍼런스 풀이 

```py
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        min_price = sys.maxsize
        
        # 최솟값과 최대 값을 계속해서 갱신
        for price in prices:
            min_price = min(min_price, price)
            profit = max(profit, price - min_price)
        
        return profit
```