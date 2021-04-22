# String

## leetcode 5. Longest Palindromic Substring

### https://leetcode.com/problems/longest-palindromic-substring/

* 파이썬 풀이

```py
class Solution:
    def longestPalindrome(self, s: str) -> str:
        # 팰린드롬 판별 및 투 포인터 확장
        def expand(left: int, right: int) -> str:
            while left >=0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            return s[left+1:right]
        
        # 해당 사항이 없을 때 빠르게 리턴
        if len(s) < 2 or s == s[::-1]:
            return s
        result = ''
        
        # 슬라이딩 윈도우 우측으로 이동
        for i in range(len(s) -1):
            result = max(result,
                         expand(i, i + 1),
                         expand(i, i + 2),
                         key=len
                        )
        return result
```

* Js 풀이

```js
var longestPalindrome = function(s) {
    let longest = '';
    const findLongestPalindrome = (str, i, j) => {
        while(i >= 0 && j < str.length && str[i] === str[j]) {
            i -= 1;
            j += 1;
        }
        // slice the qualified substring from the second last iteration
        return str.slice(i + 1, j);
    }
    for (let i = 0; i < s.length; i++) {
        // palindrome can center around 1 or 2 letters
        const current1 = findLongestPalindrome(s, i, i);
        const current2 = findLongestPalindrome(s, i, i + 1);
        const longerPalindrome = current1.length > current2.length ? current1 : current2;
        if (longerPalindrome.length > longest.length) {
            longest = longerPalindrome;
        } 
    }
    return longest;
};
```