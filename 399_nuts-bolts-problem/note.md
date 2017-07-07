```
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/nuts-bolts-problem
@Language: Markdown
@Datetime: 17-02-08 02:29
```

for (int i = 0; i < nuts.length; i++) {
            for (int j = i; j < bolts.length; j++) {
                if (compare.cmp(nuts[i], bolts[j]) == 0) {
                    String temp = bolts[j];
                    bolts[j] = bolts[i];
                    bolts[i] = temp;
                    break;
                }
            }
        }