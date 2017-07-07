```
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/find-peak-element-ii
@Language: Markdown
@Datetime: 17-02-20 16:20
```

从行的中点开始找这一行的最大值，然后判断要上一半还是下一半，时间复杂度O(nlogm)

优化：先找行中点，再找列中点，依次循环，时间复杂度O(m + n)