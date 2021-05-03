# Stack

## leetcode 739. Daily Temperatures

### https://leetcode.com/problems/daily-temperatures/

```py
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        answer = [0] * len(T)
        stack = []
        
        for i, cur in enumerate(T):
            # 현재 온도가 스택 값보다 높다면 정답 처리
            while stack and cur > T[stack[-1]]:
                last = stack.pop()
                answer[last] = i - last
            stack.append(i)
            
        return answer
```

```js
/**
 * @param {number[]} T
 * @return {number[]}
 */
var dailyTemperatures = function(T) {
    let len = T.length;
    let result = Array.from({length:len},()=>0);
    let stack = [];
    
    
    for(let i=0; i<len; i++) {
        while(stack.length && T[i] > T[stack[stack.length -1]]) {
            let last = stack.pop();
            result[last] = i - last;
        }
        stack.push(i);
    }
    return result;
};
```