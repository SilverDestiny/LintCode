```
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/find-the-duplicate-number
@Language: Markdown
@Datetime: 17-03-25 22:31
```

1. Binary Search  - O(nlogn)
Search 1 to n for result, check how many nums less or equal to mid.

2. Linked List Cycle 2 - O(n)
Consider every num as a linkedlist node, value of num as next pointer. We need to find the cycle entry for this list.