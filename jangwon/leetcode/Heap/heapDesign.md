# 이진 힙 디자인

## 클래스의 뼈대 
```py
class BinaryHeap(object):
    def __init__(self):
        self.items = [None]
    
    def __len__(self):
        return len(self.items) - 1
```

## 삽입 

- 힙에 요소를 삽입하기 위해서는 업힙 연산을 수행해야 합니다. 일반적으로 업힙 연산은 `percolate_up()`이라는 함수로 정의 합니다.

1. 요소를 가장 하위 레벨의 최대한 왼쪽으로 삽입합니다(배열로 표현 하는 경우 가장 마지막에 삽입합니다.)

2. 부모 값과 비교해 값이 더 작은 경우 위치를 변경합니다.

3. 계속해서 부모 값과 비교해 위치를 변경합니다. (가장 작은 값일 경우 루트까지 올라감)

### 구현 

```py
class BinaryHeap(object):
    def __init__(self):
        self.items = [None]
    
    def __len__(self):
        return len(self.items) - 1

# 삽입 시 실행, 반복 구조 구현
def _percolate_up(self):
    i = len(self)
    parent = i // 2
    while parent > 0:
        if self.items[i] < self.items[parent]:
            # 부모와 스왑
            self.items[parent], self.items[i] = \
                self.items[i], self.items[parent]
            
            i = parent
            parent = i // 2

def insert(self, k):
    self.items.append(k)
    self._percolate_up()

def _percolate_down(self, idx):
    left = idx * 2
    right = idx * 2 + 1
    smallest = idx

    if left <= len(self) and self.items[left] < self.items[smallest]:
        smallest = left
    
    if right <= len(left) and self.items[right] < self.items[smallest]:
        smallest = right
    
    if smallest != idx:
        self.items[idx], self.items[smallest] = \
            self.items[smallest], self.items[idx]
        self._percolate_down(smallest)

def extract(self):
    extracted = self.items[1]
    self.items[1] = self.items[len(self)]
    self.items.pop()
    self._percolate_down(1)
    return extracted
```