# String

## leetcode 937. Reorder Data in Log Files

### https://leetcode.com/problems/reorder-data-in-log-files/

```js
const reorderLogFiles = (logs) => {
  const body = s => s.slice(s.indexOf(' ') + 1); // get the body after identifier
  const isNum = c => /\d/.test(c);

  // if body same then compare identifier
  const compare = (a, b) => {
    const n = body(a).localeCompare(body(b));
    if (n !== 0) return n;
    return a.localeCompare(b);
  };

  const digitLogs = [];
  const letterLogs = [];
  for (const log of logs) {
    if (isNum(body(log))) digitLogs.push(log);
    else letterLogs.push(log);
  }
  return [...letterLogs.sort(compare), ...digitLogs];
};
```


```py
class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        letters, digits = [], []
        for log in logs:
            if log.split()[1].isdigit():
                digits.append(log)
            else:
                letters.append(log)
        
        # 2개의 키를 람다 표현식으로 정렬
        letters.sort(key=lambda x: (x.split()[1:], x.split()[0]))
        return letters + digits        
```