# String

## leetcode 344. Reverse String

### https://leetcode.com/problems/reverse-string/

**js 풀이 1**

* 내장 메소드 풀이

```js
var reverseString = function(s) {
    return s.reverse();
};
```

**js 풀이 2**

* 헬퍼 함수 생성해서 `swap` 풀이

```js
var reverseString = function(s) {
    const helper = (start,end,s) => {
        if(start >= end) return;
        else {
            let tmp;
            tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            helper(start+1,end-1,s);
        }
    }
    helper(0,s.length-1,s);
};
```

**파이썬 풀이 1** 

* 투 포인터를 사용하여 풀이

```py
class Solution:
    def reverseString(self, s: List[str]) -> None:
        left, right = 0, len(s) - 1
        while left < right:
            s[left], s[right] = s[right], s[left]
            left += 1
            right -= 1
```

**파이썬 풀이 2**

```py
class Solution:
    def reverseString(self, s: List[str]) -> None:
        s.reverse()        
```