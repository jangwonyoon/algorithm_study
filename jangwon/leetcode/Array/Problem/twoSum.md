# Array

## 1. Two Sum

<p align="center">
  <img src="https://user-images.githubusercontent.com/33803975/107840781-0306e580-6df9-11eb-86cc-67788ce7446f.png"/>
</p>

### https://leetcode.com/problems/two-sum/

**문제 풀이**

* 내 풀이: Brute Force 방법

```js
var twoSum = function(nums, target) {
    let arr = [];
    
    for(let i=0; i<nums.length; i++) {
        for(let j=i+1; j<nums.length; j++) {
            if(nums[i] + nums[j] === target){
                const idx1 = i;
                const idx2 = j;
                arr.push(i,j);
            }
        }
    }
    
    return arr;
};
```


```js
var twoSum = function(nums, target) {
    let result = [];
    nums.reduce((acc,val,idx)=>{
        let sub = target - val;
        for(let i=idx+1; i<nums.length; i++) {
            if(sub === nums[i]) {
                // console.log(idx,i);
              result.push(idx,i);
                
            }
        }
    },[])
    
    return result;
};
```


```js

```

**레퍼런스 풀이**

* Approach 2: Two-pass Hash Table

```js
var twoSum = function(nums, target) {
    const hash = new Map();
    
    // 해시에 배열의 요소 값과 인덱스를 삽입
    for(let i=0; i<nums.length; i++) {
        hash.set(nums[i],i);
    }
    
    for(let i=0; i< nums.length; i++) {
        let complement = target - nums[i];
        if(hash.has(complement) && hash.get(complement) !== i){
            return [i,hash.get(complement)];
        } 
    }
};

```

* Approach 3: One-pass Hash Table


```js
var twoSum = function(nums, target) {
    const hash = new Map();
    
    for(let i=0; i<nums.length; i++) {
        let complement = target - nums[i];
        if(hash.has(complement)) {
            return [i,hash.get(complement)];
        }
        hash.set(nums[i],i);
    }
};
```



### 배운점

* `has()`와 `hasOwnProperty()` 함수의 차이 has는 Map객체에서 사용 hasOwnProperty는 객체에서 사용