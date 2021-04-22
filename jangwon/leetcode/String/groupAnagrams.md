# String

## leetcode 49. Group Anagrams

### https://leetcode.com/problems/group-anagrams/


**파이썬 풀이**

 `sorted`를 사용하여 문자열 정렬, 나온 결과인 리스트를 키로 사용하기 위해 `join`을 통해 합치고
 이 값을 키로 사용하는 딕셔너리를 구성한다.

```py
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = collections.defaultdict(list)
        
        for word in strs:
            anagrams[''.join(sorted(word))].append(word)
            
        return list(anagrams.values())
 ```
