# DFS,BFS

## leetcode 17. Letter Combinations of a Phone Number

### https://leetcode.com/problems/letter-combinations-of-a-phone-number/

```py
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        dic = { '2':'abc','3':'def','4':'ghi','5':'jkl',
        '6':'mno','7':'pqrs','8':'tuv','9':'wxyz' }
        
        def dfs(index, path):
            # 끝까지 검색하면 백트래킹
            if len(path) == len(digits):
                result.append(path)
                return
            
            # 입력값 자릿수 단위 반복
            for i in range(index, len(digits)):
                # 숫자에 해당하는 모든 문자열 반복
                for j in dic[digits[i]]:
                    dfs(i + 1, path + j)
        
        # 예외 처리 
        if not digits:
            return []
        
        result = []
        dfs(0,'')
        
        return result
```


```js
/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    if (digits == null || digits.length === 0) return [];
    let keypad = {
        '2':'abc',
        '3':'def',
        '4':'ghi',
        '5':'jkl',
        '6':'mno',
        '7':'pqrs',
        '8':'tuv',
        '9':'wxyz'
    };
    
    let res = [];
    const dfs = (i,p) => {
        if(p.length === digits.length){
            res.push(p);
            return;
        }
        
        for(const c of keypad[digits[i]]) {
            dfs(i + 1, p + c)
        }
    }
    
    dfs(0,'')
    return res;
};
```