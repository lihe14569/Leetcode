class Solution {
    public class UF {
        int[] parent;
        int[] size;
        public UF(int n) {
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
            Arrays.fill(size, 1);
        }
        public int find(int x) {
            if(parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        public void union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if(rootX == rootY) return;
            if(size[rootX] <= size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
        public int getSize(int x) {
            return size[find(x)];
        }
    }
    public int earliestAcq(int[][] logs, int n) {
        //union-find
        UF uf = new UF(n);
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        for(int[] log : logs) {
            int a = log[1], b = log[2];
            uf.union(a, b);
            if(uf.getSize(a) == n || uf.getSize(b) == n) 
                return log[0];
        }
        return -1;
    }
}