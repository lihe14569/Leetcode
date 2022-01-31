union-find + backtrack+ bitmask
```
class UnionFind{
int[] parent;
int[] size;
public UnionFind(int n) {
parent = new int[n];
size = new int[n];
for(int i = 0; i < n; i++) parent[i] = i;
Arrays.fill(size, 1);
}
public int find(int x) {
if(parent[x] != x) parent[x] = find(parent[x]);
return parent[x];
}
public void union(int x, int y) {
int rootX = find(x), rootY = find(y);
if(rootX == rootY) return;
if(size[rootX] < size[rootY]) {
parent[rootX] = rootY;
size[rootY] += size[rootX];
} else {
parent[rootY] = rootX;
size[rootX] += size[rootY];
}
}
public boolean isConnected(int x, int y) {
return find(x) == find(y);
}
public int getSize(int p) {
return size[p];
}
}
public int[] groupStrings(String[] words) {
int n = words.length;
UnionFind uf = new UnionFind(n);
int[] mask = new int[n];
Map<Integer, Integer> map = new HashMap<>();
for(int i = 0; i < n; i++) {
String s = words[i];
int m = 0;
for(int j = 0; j < s.length(); j++) {
char c = s.charAt(j);
m = m | 1 << (c - 'a');
}
mask[i] = m;
map.put(m, i);
}
for(int i = 0; i < n; i++) {
String s = words[i];
for(int j = 0; j < s.length();j++) {
m = m | (1 << c - 'a');