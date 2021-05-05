# 정렬

## 프로그래머스. K번째수

### https://programmers.co.kr/learn/courses/30/lessons/42748?language=javascript

```js
function solution(array, commands) {
    let result = [];
    
    for(const [i, j, k] of commands) {
        let arr = array.slice(i-1, j).sort((a,b) => a - b);
        arr.map((el,idx) => {
            if(k -1 === idx) {
                result.push(el);
            }
        })
    }
    
    return result;
}
```
* 파이썬 풀이 1

```py
def solution(array, commands):
    result = []
    
    for idx, [i, j, k] in enumerate(commands):
        # 배열 슬라이싱 후 sorted 함수를 통한 정렬
        s_arr = sorted(array[i - 1:j])
        
        # k는 인덱스 + 1 이기 때문에 -1을 해준 값을 result에 삽입
        result.append(s_arr[k - 1])
        
    return result
```

* 파이썬 풀이 2

```py
def solution(array, commands):
    result = []
    
    for command in commands:
        i, j, k = command
        result.append(sorted(array[i-1: j])[k-1])
    return result
```

### 배운점, 의문점

- 배열 슬라이싱이후 `s_arr = array[i - 1:j].sort()` 구문에서 `None`이 나오는 이유를 모르겠음 일단 `sorted`함수를 사용하여 해결 

- 레퍼런스 코드를 통해 `enumerate` 대신 패킹, 언패킹으로 요소에 접근하는 방법
