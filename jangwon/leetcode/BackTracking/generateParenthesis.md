# Backtracking

## leetcode 22. Generate Parentheses

### https://leetcode.com/problems/generate-parentheses/

```js
/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    let result = [];
    
    const dfs = (l,r,s) => {
        if(l>r) return;
        if(l === 0 && r === 0) {
            result.push(s);
        }
        if(l > 0) dfs(l-1,r,s+'(');
        if(r > 0) dfs(l,r-1,s+')');
    }
    
    dfs(n,n,'')
    return result;
    
};
```