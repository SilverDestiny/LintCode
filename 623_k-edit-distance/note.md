```
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/k-edit-distance
@Language: Markdown
@Datetime: 17-02-22 22:41
```

把所有的word建成一个trie树，从trie树的root开始计算，一层一层的向下计算，类似滚动数组做Edit Distance
优化的本质是去掉了相同prefix的重复计算