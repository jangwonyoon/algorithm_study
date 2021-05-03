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

**최소 힙을 사용한 파이썬 풀이**

```py
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freqs = collections.Counter(nums)
        freqs_heap = []
        # 힙에 음수로 삽입
        for f in freqs:
            heapq.heappush(freqs_heap, (-freqs[f],f))
        
        topk = list()
        # k번 만큼 추출, 최소 힙(min-heap)이므로 가장 작은 음수 순으로 추출
        
        for _ in range(k):
            topk.append(heapq.heappop(freqs_heap)[1])
            
        return topk
        
```

> 파이썬의 heapq 모듈은 최소 힙만 지원한다. 

> 힘은 키 순서대로 정렬이 된다. 그렇기 때문에 풀이에서 빈도 수를 키로 구현했다. 파이썬은 최소 힙만 지원함으로 음수로 변환하여 가장 높았던 값을 도출하였다. 