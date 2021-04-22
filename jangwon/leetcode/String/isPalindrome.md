# String

## 125. Valid Palindrome

### https://leetcode.com/problems/valid-palindrome/

**Js 풀이 1**

```js
var isPalindrome = function(s) {
    let str = s.toLowerCase().replace(/[^a-z|0-9]/g,'');
    let mid = Math.floor(str.length / 2);
    let start = str.slice(0,mid);
    let end = str.slice(mid).split('');
    if(mid !== str.length - mid) {
        let endlen = Math.abs(str.length - (mid * 2));
        for(let i=0; i<endlen; i++) {
            end.shift();
        }
    }
    
    if(start === end.reverse().join('')) return true;
    return false;
};
```

**Js 풀이 2**

```js
var isPalindrome = function(s) {
    let str = s.toLowerCase().replace(/[^a-z|0-9]/g,'').split('');
    let mid = Math.floor(str.length / 2);
    for(let i=0; i<mid; i++) {
        if(str.shift() !== str.pop()) return false;
    }
    return true;
};
```

**파이썬 풀이 1**

```py
class Solution:
    def isPalindrome(self, s: str) -> bool:
        strs = []
        for char in s:
            if char.isalnum():
                strs.append(char.lower())
        # 팰린드롬 확인
        while len(strs) > 1:
            if strs.pop() != strs.pop(0):
                return False
        return True
```

**파이썬 풀이 2**

collections의 Deque를 사용하여 풀이 
  
* 리스트의 `pop(0)`이 O(n)인 데 반해서 데크의 `popleft()`은 O(1)이기 때문에 풀이 1의 비해서 시간 복잡도가 크게 줄어든다. 

```py
class Solution:
    def isPalindrome(self, s: str) -> bool:
        
        # 자료형 데크로 선언
        strs: Deque = collections.deque()
        
        for char in s:
            if char.isalnum():
                strs.append(char.lower())
                
        while len(strs) > 1:
            if strs.popleft() != strs.pop():
                return False
        
        return True;
```

**파이썬 풀이 3**

```py
class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        
        # 정규식으로 불 필요 문자열 필터링
        s = re.sub('[^a-z0-9]',"",s)
        
        return s == s[::-1] # 슬라이싱
```