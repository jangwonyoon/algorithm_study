# Stack 

## leetcode 20. Valid Parentheses

### https://leetcode.com/problems/valid-parentheses/submissions/

```py
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        table = {
            ')': '(',
            '}': '{',
            ']': '['
        }
        
        # 스택 이용 예외 처리 및 일치 여부 판별
        for char in s:
            if char not in table:
                stack.append(char)
            elif not stack or table[char] != stack.pop():
                return False
        
        return len(stack) == 0            
```

```js
var isValid = function(s) {
  let stack = [];
  let table = {
        ')': '(',
        '}': '{',
        ']': '['
    };
    
    for(const str of s) {
        if(!table[str]) {
            stack.push(str);
        }
        else if(table[str] !== stack.pop()) {
            return false;
        }
    }
    
    return stack.length === 0 ? true : false;
};
```