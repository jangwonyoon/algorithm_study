# 정렬

## programmers. H-index

```py
def solution(citations):
    sorted_citations = sorted(citations, reverse=True)
    start = 0
    while start + 1 <= sorted_citations[start]:
        start += 1
    
    return start
```