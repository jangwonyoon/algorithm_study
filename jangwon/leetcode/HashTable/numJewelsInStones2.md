# HashTable

## leetcode 771. Jewels and Stones

### https://leetcode.com/problems/jewels-and-stones/


**해시 테이블 없이 풀이** 

```js
const numJewelsInStones = function(jewels, stones) {
    let result = 0;
    let jewel = jewels.split('');
    
    for(const x of stones.split('')) {
        if(jewel.includes(x)) {
            result++;
        }
    }
    
    return result;
};
```

```js
const numJewelsInStones = function(jewels, stones) {
    const jewel = new Set(jewels)
    return stones.split('').reduce((res, s) => res + jewel.has(s), 0)
};
```

**해시 테이블 기본 파이썬 풀이**

```py
class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        hash = {}
        count = 0
        
        for s in stones:
            if s not in hash:
                hash[s] = 1
            else:
                hash[s] += 1
        
        for j in jewels:
            if j in hash:
                count += hash[j]
        
        return count
```

**`defaultdict` 를 이용한 비교 생략**

```py
class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        hash = collections.defaultdict(int)
        count = 0
        
        # 비교 없이 돌(S) 빈도 수 계산
        for char in stones:
            hash[char] += 1
        # 비교 없이 보석(J) 빈도 수 합산
        for char in jewels:
            count += hash[char]
            
        return count
```

**`collections.Counter`를 사용한 풀이**

```py
class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        hash = collections.Counter(stones) # 돌(S) 빈도 수 계산
        count = 0
        
        # 비교 없이 보석(J) 빈도 수 합산
        for char in jewels:
            count += hash[char]
            
        return count
```            

> counter는 존재하지 않는 키의 경우 KeyError를 발생하는 것이 아닌 0을 출력 해주기 때문에, defaultdict와 마찬가지로 에러에 대한 예외 처리를 할 필요가 없다. 단순히 J에 포함된 문자의 개수를 계산하기만 하면 된다. 

**파이썬 방식으로 풀이**

```py
class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        return sum(s in jewels for s in stones)
```