# Backtracking

## leetcode 216. Combination Sum III

### https://leetcode.com/problems/combination-sum-iii/

```js
/**
 * @param {number} k
 * @param {number} n
 * @return {number[][]}
 */
var combinationSum3 = function(k, n) {
    const res = [];
    
    const dfs = (arr,sum,idx) => {
        if(sum > n) return;
        if(arr.length === k) {
            if(sum === n) {
                res.push(arr);
            }
        }
        for(let i=idx; i<10; i++) {
            dfs([...arr,i],sum+i,i+1);
        }
    }
    
    dfs([],0,1);
    
    return res;
};
```