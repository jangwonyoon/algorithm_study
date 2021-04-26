# List

## leetcode 234. Palindrome Linked List

### https://leetcode.com/problems/palindrome-linked-list/

```py
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        q: List = []
            
        node = head
        
        while node is not None:
            q.append(node.val)
            node = node.next
            
        #팰린드롬 확인 
        while len(q) > 1:
            if q.pop(0) != q.pop():
                return False
        
        return True
```

```py
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        
        # 데크 자료형 선언
        q: Deque = collections.deque()
        node = head
        
        if not head:
            return True
        
        while node is not None:
            q.append(node.val)
            node = node.next
        
        while len(q) > 1:
            if q.popleft() != q.pop():
                return False
            
        return True
```

```py
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        rev = None
        slow = fast = head
        while fast and fast.next:
            fast = fast.next.next
            rev, rev.next, slow = slow, rev, slow.next
        if fast:
            slow = slow.next
        while rev and rev.val == slow.val:
            slow = slow.next
            rev = rev.next
        return not rev
```


```js 
var isPalindrome = function(head) {
    if(head == null || head.next == null) return true;
        var slow = head;
        var fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverseList(slow.next);
        slow = slow.next;
        while(slow != null) {
            if(head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
};

var reverseList = function(head) {
        var pre = null;
        var next = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
};
```