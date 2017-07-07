```
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/minimum-size-subarray-sum
@Language: Markdown
@Datetime: 17-02-11 19:20
```

if (nums == null || nums.length == 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            int sum = 0;
            for (; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
            if (i == nums.length && sum < s) {
                break;
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;