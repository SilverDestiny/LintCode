```
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/build-post-office-ii
@Language: Markdown
@Datetime: 17-02-07 21:23
```

房子的个数应该远远小于地图的大小，才能用反向的思路做比较好
房子的个数较多时，正向的思路好

public class Solution {
/**
* @param grid a 2D grid
* @return an integer
*/
class Node {
int x, y;
public Node(int x, int y) {
this.x = x;
this.y = y;
}
}
public int shortestDistance(int[][] grid) {
// Write your code here
if (grid == null || grid.length == 0 || grid[0].length == 0) {
return -1;
}
int m = grid.length;
int n = grid[0].length;
ArrayList&lt;Node&gt; nodes = new ArrayList&lt;Node&gt;();
for (int i = 0; i &lt; m; i++) {
for (int j = 0; j &lt; n; j++) {
if (grid[i][j] == 1) {
nodes.add(new Node(i, j));
}
}
}
if (nodes.size() == m * n) {
return -1;
}
int min = Integer.MAX_VALUE;
for (int i = 0; i &lt; m; i++) {
for (int j = 0; j &lt; n; j++) {
if (grid[i][j] == 0) {
min = Math.min(min, bfs(grid, i, j, nodes, m, n));
}
}
}
if (min == Integer.MAX_VALUE) {
return -1;
}
return min;
}
int[] dx = {-1, 1, 0, 0};
int[] dy = {0, 0, -1, 1};
private int bfs(int[][] grid, int i, int j, ArrayList&lt;Node&gt; nodes, int m, int n) {
int sum = 0;
for (Node node : nodes) {
int path = -1;
boolean[][] visited = new boolean[m][n];
Queue&lt;Node&gt; queue = new LinkedList&lt;Node&gt;();
queue.offer(new Node(i, j));
visited[i][j] = true;
boolean exist = false;
while (!queue.isEmpty()) {
path++;
int size = queue.size();
for (int k = 0; k &lt; size; k++) {
Node temp = queue.poll();
for (int l = 0; l &lt; 4; l++) {
int x = temp.x + dx[l];
int y = temp.y + dy[l];
if (x == node.x &amp;&amp; y == node.y) {
path++;
exist = true;
sum += path;
queue.clear();
k = size;
break;
}
if (x &gt;= 0 &amp;&amp; x &lt; m &amp;&amp; y &gt;= 0 &amp;&amp; y &lt; n &amp;&amp; grid[x][y] == 0 &amp;&amp; !visited[x][y]) {
queue.offer(new Node(x, y));
visited[x][y] = true;
}
}
}
}
if (!exist) {
return Integer.MAX_VALUE;
}
}
return sum;
}
}