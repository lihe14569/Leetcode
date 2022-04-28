Method1: dijikstra
```
class Solution {
int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
public int minimumEffortPath(int[][] heights) {
int m = heights.length, n = heights[0].length;
int[][] dis = new int[m][n];
for(int i = 0; i < m; i++) Arrays.fill(dis[i], Integer.MAX_VALUE);
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
pq.offer(new int[]{0, 0, 0});//distance, r, c
while(!pq.isEmpty()) {
int[] node = pq.poll();
int d = node[0], r = node[1], c = node[2];
if(d > dis[r][c]) continue;
if(r == m - 1 && c == n - 1) return d;
for(int[] dir : dirs) {
int nr = r + dir[0];
int nc = c + dir[1];
if(nr >= 0 && nr < m && nc >= 0 && nc < n) {
int nd = Math.max(d, Math.abs(heights[nr][nc] - heights[r][c]));
if(nd < dis[nr][nc]) {
dis[nr][nc] = nd;
pq.offer(new int[]{dis[nr][nc], nr, nc});
}
}
}
}
return 0;
}
}
```