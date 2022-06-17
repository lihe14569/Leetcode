右上角开始遍历，确保双向性，即即可减小，column index向左；也可增大，row index向右
```
class Solution {
public boolean searchMatrix(int[][] matrix, int target) {
int m = matrix.length, n = matrix[0].length;
int r = 0, c = n - 1;
while(r < m && c >= 0) {
if(matrix[r][c] == target) return true;
else if(matrix[r][c] < target) {
r++;
} else{
c--;
}
}
return false;
}
}
```