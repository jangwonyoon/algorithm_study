# Array, Two Pointer , HashTable

## 1213. Intersection of Three Sorted Arrays

### https://leetcode.com/problems/intersection-of-three-sorted-arrays/


```js
var arraysIntersection = function(arr1, arr2, arr3) {
    let result = [];
    let hash = new Map();
    for(const el of arr1) {
        if(!hash.has(el)) {
            hash.set(el,1)
        }else{
            hash.set(el,hash.get(el) + 1);
        }
    }
    
    for(const el of arr2) {
        if(!hash.has(el)) {
            hash.set(el,1)
        }else{
            hash.set(el,hash.get(el) + 1);
        }
    }
    
    for(const el of arr3) {
        if(!hash.has(el)) {
            hash.set(el,1)
        }else{
            hash.set(el,hash.get(el) + 1);
        }
    }
    
    for(const el of hash) {
        if(el[1] === 3) {
            result.push(el[0]);
        }
    }
    return result;
};
```

```js
var arraysIntersection = function(arr1, arr2, arr3) {
    let p1=0, p2=0, p3=0;
    let res = [];
    
    while(p1 < arr1.length && p2 < arr2.length && p3 < arr3.length ) {
        if(arr1[p1] === arr2[p2] && arr1[p1] === arr3[p3]) {
            res.push(arr1[p1]);
            p1++;
            p2++;
            p3++;
        }else {
            if(arr1[p1] < arr2[p2]) {
                p1++;
            } else if(arr2[p2] < arr1[p1]) {
                p2++;
            } else if(arr1[p1] > arr3[p3]) {
                p3++;
            } else if(arr1[p1] < arr3[p3]) {
                p1++;
            }
        }
    }
    
    return res;
};
```



```js
/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @param {number[]} arr3
 * @return {number[]}
 */

var arraysIntersection = function(arr1, arr2, arr3) {
    let res = [];
    let p1 = 0;
    let p2 = 0; 
    let p3 = 0;
    
    while(p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {
        if (arr1[p1] == arr2[p2] && arr2[p2] == arr3[p3]) {
            res.push(arr1[p1]);
            p1++;
            p2++;
            p3++;
        }else{
            if (arr1[p1] < arr2[p2]) {
                p1++;
            } else if (arr2[p2] < arr3[p3]) {
                p2++;
            } else {
                p3++;
            }
        }
    }
    return res;
};
```