```js
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    let result = [];
    let n = nums.length;
    let ch = Array.from({length:n},()=>0);
    let tmp = Array.from({length:n},()=>0);
    
    const dfs = (L) => {
        if(L===n) {
            result.push(tmp.slice());
        }else{
            for(let i=0; i<n; i++) {
                if(ch[i] === 0) {
                    ch[i] = 1;
                    tmp[L] = nums[i];
                    dfs(L+1);
                    ch[i] = 0;
                }
            }
        }
    }
    dfs(0);
    return result;
};
```

```py
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        results = []
        prev_elements = []
        
        def dfs(elements):
            # 리프 노드일 때 결과 추가
            if len(elements) == 0:
                results.append(prev_elements[:]) # 얕은 복사
            
            # 순열 생성 재귀 호출
            for e in elements:
                next_elements = elements[:]
                next_elements.remove(e)
                
                prev_elements.append(e)
                dfs(next_elements)
                prev_elements.pop()
                
        
        dfs(nums)
        return results
```