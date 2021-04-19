# HashTable

## leetcode 347. Top K Frequent Elements

### https://leetcode.com/problems/top-k-frequent-elements/

* 내 풀이

```js
var topKFrequent = function(nums, k) {
    let hash = new Map();
    let arr = [];
    let result = [];
    for(const num of nums) {
        if(!hash.has(num)) {
            hash.set(num,1);
        }else{
            hash.set(num,hash.get(num)+1);
        }
    }
    for(const [key,val] of hash) {
        arr.push([key,val]);
    }
    
    arr.sort((a,b)=>b[1]-a[1]);
    
    for(let i=0; i<k; i++) {
        result.push(arr[i][0]);
    }
    
    return result;
};
```

```js
var topKFrequent = function(nums, k) {
    let result = [];
    let hash = {};
    nums.forEach((n) => hash[n] ? hash[n]++ : hash[n] = 1);
    let sortedArr = Object.keys(hash).sort((a,b)=>hash[b]-hash[a]);
    
    for(let i=0; i<k; i++) {
        result.push(sortedArr[i]);
    }
    return result;
};
```