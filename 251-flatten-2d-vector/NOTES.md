solution:
双指针
```
class Vector2D {
int i, j;
int[][] vec;
public Vector2D(int[][] vec) {
i = 0;
j = 0;
this.vec = vec;
}
public int next() {
if(hasNext()) {
return vec[i][j++];
} else {
return -1;
}
}
public boolean hasNext() {
while(i < vec.length && j == vec[i].length) {
i++;
j = 0;
}
return i < vec.length;
}
}
​
```