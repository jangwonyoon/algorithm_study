# 연결 리스트를 이용한 스택 ADT 구현

```py
class Node:
  def __init__(self, item, next):
    self.item = item
    self.next = next
```

초 기화 함수 `__init__`()에서 노드의 값은 item으로, 다음 노드를 가리키는 포인터는 next로 정의한다. 이제 스택의 연산인 `push()`와 `pop`를 담은 스택의 클래스를 다음과 같이 정의한다. 

```py
class Stack:
  def __init__(self):
    self.last = None

  def push(self, item):
    self.last = Node(item, self.last)

  def pop(self):
    item = self.last.item
    self.last = self.last.next
    return item
```
