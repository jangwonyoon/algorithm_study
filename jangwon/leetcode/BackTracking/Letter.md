# BackTracking(DFS)

## [leetcode] 784. Letter Case Permutation

### https://leetcode.com/problems/letter-case-permutation/

```js

/**
 * @param {string} S
 * @return {string[]}
 */
var letterCasePermutation = function(S) {
    return perLetter(S,0);
};

const isAlpha = (str) => {
    return /[a-z|A-z]/i.test(str);
}

const perLetter = (str,pos,res=[],curr='') => {
    let n = str.length;
    if( pos === n || curr.length === n){
        res.push(curr);
    }else{
        if(isAlpha(str[pos])) {
            let up = str[pos].toUpperCase();
            let low = str[pos].toLowerCase();
            perLetter(str,pos+1,res,curr+up);
            perLetter(str,pos+1,res,curr+low);
        }else{
            perLetter(str,pos+1,res,curr+str[pos]);
        }
    }
    return res;
}
```