# two-pointer, Array, Stack, DP

## leetcode 42. Trapping Rain Water

### https://leetcode.com/problems/trapping-rain-water/

**javaScript 투 포인터 풀이**

```js
var trap = function(height) {
    let result = 0;
    let left = 0;
    let right = height.length -1;
    let left_max = height[left];
    let right_max = height[right];
    
    while(left < right) {
        left_max = Math.max(left_max,height[left]);
        right_max = Math.max(right_max,height[right]);
        
        if(left_max <= right_max) {
            result += left_max - height[left];
            left += 1
        }
        else{
            result += right_max - height[right];
            right -= 1;
        }
    } 
    return result;
};
```

**python 투 포인터 풀이**

```py
class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        
        volume = 0
        left, right = 0, len(height) -1
        left_max, right_max = height[left], height[right]
        
        while left < right:
            left_max, right_max = max(left_max, height[left]), max(right_max, height[right])
            # 더 높은 쪽으로 투 포인터 이동 
            if left_max <= right_max:
                volume += left_max - height[left]
                left += 1
            else:
                volume += right_max - height[right]
                right -= 1
                
        return volume
```

**파이썬 스택 풀이**

```py
class Solution:
    def trap(self, height: List[int]) -> int:
        stack = []
        volume = 0
        
        for i in range(len(height)):
            # 변곡점을 만나는 경우
            while stack and height[i] > height[stack[-1]]:
                # 스택에서 꺼낸다.
                top = stack.pop()
                
                if not len(stack):
                    break
                    
                # 이전과의 차이만큼 물 높이 처리
                distance = i - stack[-1] -1
                waters = min(height[i],height[stack[-1]]) - height[top]
                
                volume += distance * waters
                
            stack.append(i)
        return volume
```
